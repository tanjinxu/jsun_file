package fileTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file2 {
    public static void main(String[] args) throws IOException {
        String srcFile = "/a.txt";
        String destFile = "/b.txt";

        // method1(srcFile, destFile);
        // method2(srcFile, destFile);
        // method3(srcFile, destFile);
        // method4(srcFile, destFile);
    }

    private static void method4(String srcFile, String destFile) throws IOException {
        BufferedInputStream r = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream w = new BufferedOutputStream(new FileOutputStream(destFile));
        int len = 0;
        byte[] bys = new byte[1024];
        while ((len = r.read(bys)) != -1) {
            w.write(bys, 0, len);
        }
        r.close();
        w.close();// @@
    }

    private static void method3(String srcFile, String destFile) throws IOException {
        BufferedInputStream r = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream w = new BufferedOutputStream(new FileOutputStream(destFile));
        int len = 0;
        while ((len = r.read()) != -1) {
            w.write(len);
        }
        r.close();
        w.close();
    }

    private static void method2(String srcFile, String destFile) throws IOException {
        FileInputStream r = new FileInputStream(srcFile);
        FileOutputStream w = new FileOutputStream(destFile);
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = r.read(bys)) != -1) {
            w.write(bys, 0, len);
        }
        r.close();
        w.close();
    }

    private static void method1(File srcFile, File destFile) throws IOException {
        FileInputStream r = new FileInputStream(srcFile);
        FileOutputStream w = new FileOutputStream(destFile);
        int len = 0;
        while ((len = r.read()) != -1) {
            w.write(len);
        }
        r.close();
        w.close();//22222
    }
}
