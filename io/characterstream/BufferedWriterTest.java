package com.vsu.io.characterstream;

/** BufferedWriter
 * Created by vsu on 2017/11/19.
 */


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Author: vsu
 * @Description: BufferedWriter的使用
 * @Date: 2017/11/19
 *
 *
 * BufferedWriter:字符缓冲输出流(高级流),将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 * 可以指定缓冲区的大小，或者接受默认的大小。在大多数情况下，默认值就足够大了。
 */



public class BufferedWriterTest {

    public static void main(String[] args) {

        io();
    }

    public static void io(){

        //打开文件
        //采用try with resources 自动关闭流
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:\\io\\ioq.txt", true)))
        ){

            bufferedWriter.append("zxcvb\r\n");
            bufferedWriter.append("测试 BufferedWriter\r\n");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
