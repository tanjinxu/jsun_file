package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class file1 {

    public static void main(String[] args) throws IOException {
        String srcString = "/home/jxun/a.txt";
        String destString = "/home/jxun/b.txt";
        method1(srcString, destString);
        // method2(srcString, destString);
        // method3(srcString, destString);
        // method4(srcString, destString);
        // method5(srcString, destString);
    }

    private static void method5(String srcString, String destString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static void method4(String srcString, String destString) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(srcString)));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destString, true)));
        char[] bys = new char[1024];
        int len = 0;
        while ((len = r.read(bys)) != -1) {
            w.write(bys, 0, len);
        }
        r.close();
        w.close();
    }

    private static void method3(String srcString, String destString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destString, true)));

        int ch = 0;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }

        bw.close();
        br.close();
    }

    private static void method2(String srcString, String destString) throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(destString);

        char[] chs = new char[1024];
        int len = 0;
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }

        fw.close();
        fr.close();
    }

    private static void method1(String srcString, String destString) throws IOException {
        FileReader r = new FileReader(srcString);
        FileWriter w = new FileWriter(destString);
        int len = 0;
        while ((len = r.read()) != -1) {
            w.write(len);
        }
        r.close();
        w.close();//@@@@$$$$$
    }
}
