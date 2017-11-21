package com.vsu.io.characterstream;

/** OutputStreamWriter
 * Created by vsu on 2017/11/19.
 */

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Author: vsu
 * @Description: OutputStreamWriter:字符输出流，这是一个高级流，用于写出文本数据，OutputStreamWriter的最主要的特点就是可以将指定的字符串按照特定的字符集转换为字节流之后写出。
 * @Date: 2017/11/19
 */


public class OutputStreamWriterTest {

    public static void main(String[] args) {
        io();
    }

    public static void io(){

        try(
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("H:\\io\\ioq.txt", true))
        ){

            outputStreamWriter.write("reqqq\r\n");
            outputStreamWriter.append("测试 OutputStreamWriter\r\n");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
