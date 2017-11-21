package com.vsu.io.characterstream;

/** InputStreamReader
 * Created by vsu on 2017/11/19.
 */


import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author: vsu
 * @Description: InputStreamReader使用
 * @Date: 2017/11/19
 *
 *
 * InputStreamReader:字符输入流(高级流),用于读入文本数据.InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
 * 它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
 */



public class InputStreamReaderTest {

    public static void main(String[] args) {
        //ioChar();
        ioArrayChar();
    }

    public static void ioChar(){

        try(
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("H:\\io\\io.txt"))
        ){

            int ch;
            while ( (ch = inputStreamReader.read()) != -1){
                System.out.println( (char)ch);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void ioArrayChar(){
        try(
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("H:\\io\\io.txt"))
        ){

            int ch;
            char[] arr = new char[1024];
            String str = null;
            while ( (ch = inputStreamReader.read(arr)) != -1){
                str += new String(arr, 0, ch);
            }
            System.out.println(str);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
