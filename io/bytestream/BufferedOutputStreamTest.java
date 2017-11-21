package com.vsu.io.bytestream;

/** BufferedOutputStream
 * Created by vsu on 2017/11/19.
 */


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @Author: vsu
 * @Description: BufferedOutputStream
 * @Date: 2017/11/19
 */


public class BufferedOutputStreamTest {

    public static void main(String[] args) {
        io();
    }

    public static void io(){

        try(
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("H:\\io\\ioq.txt", true))
        ){

            //一次写入一个字节数组
           bufferedOutputStream.write("测试 BufferedOutputStream".getBytes());
           bufferedOutputStream.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
