package com.vsu.io.bytestream;

/** BufferedInputStream
 * Created by vsu on 2017/11/19.
 */


import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @Author: vsu
 * @Description: BufferedInputStream
 * @Date: 2017/11/19
 */



public class BufferedInputStreamTest {

    public static void main(String[] args) {
        //ioChar();
        ioArrayChar();
    }

    public static void ioChar(){

        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("H:\\io\\io.txt"))
        ){

            int ch;
            while ( (ch = bufferedInputStream.read()) != -1){
                System.out.println( (char)ch);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void ioArrayChar() {
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("H:\\io\\io.txt"))
        ){

            int ch;
            byte[] arr = new byte[1024];
            String str = null;
            while ( (ch = bufferedInputStream.read(arr)) != -1){
                str += new String(arr, 0, ch);
            }
            System.out.println(str);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
