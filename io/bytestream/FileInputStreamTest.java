package com.vsu.io.bytestream;

/** FileInputStream
 * Created by vsu on 2017/11/19.
 */


import java.io.FileInputStream;

/**
 * @Author: vsu
 * @Description: FileInputStream 从文件系统中的某个文件中获得输入字节
 * @Date: 2017/11/19
 *
 *
 * BufferedInputStream:缓冲字节输入流，是一个高级流(处理流)，与其他低级流配合使用。
 */



public class FileInputStreamTest {

    public static void main(String[] args) {
        //ioChar();
        ioArrayChar();
    }

    public static void ioChar(){

        try(
                FileInputStream fileInputStream = new FileInputStream("H:\\io\\io.txt")
        ){

            int ch;
            while ( (ch = fileInputStream.read()) != -1){
                System.out.println( (char)ch);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void ioArrayChar() {
        try (
                FileInputStream fileInputStream = new FileInputStream("H:\\io\\io.txt")
        ) {

            byte[] arr = new byte[1024];
            String str = null;
            int ch;
            while ((ch = fileInputStream.read(arr)) != -1) {
                str += new String(arr, 0, ch);
            }
            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
