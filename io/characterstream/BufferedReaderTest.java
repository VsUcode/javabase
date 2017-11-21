package com.vsu.io.characterstream;

/** BufferedReader的使用
 * Created by vsu on 2017/11/19.
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author: vsu
 * @Description: BufferedReader的使用
 * @Date: 2017/11/19
 *
 *
 * BufferedReader:缓冲字符输入流，高级流。从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。可以以行为单位读取字符串。
 */



public class BufferedReaderTest {

    public static void main(String[] args) {
      //  ioChar();
        ioString();
    }

    public static void ioChar(){

        //逐个字符读取
        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\io\\io.txt")))
        ){

            int ch;
            while ((ch = bufferedReader.read()) != -1){
                System.out.println((char)ch);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void ioString(){
        //逐行读取
        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\io\\io.txt")))
        ){

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
