package priv.carl.cx.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description: TODO
 * @author: chenxuan
 * @email: chenx265@163.com
 * @date: 2018/2/10 10:02
 */
public class Io {


    public static void main(String[] args) {
        printHex("H:\\carl.txt");
    }

    public static void ioByte() {
        String s = "你好Ab";
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            System.out.println(Integer.toHexString(b & 0xff));
        }
    }

    public static void ioFile() {
    }

    public static void ioFiles() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("h:\\aaa", "rw");
            raf.getFilePointer();
            int i = 0x7fffffff;
            raf.writeInt(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printHex(String fileName) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            int b;
            int i = 1;
            while ((b = in.read()) != -1) {
                if (b <= 0xf) {
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
