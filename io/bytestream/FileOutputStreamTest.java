package com.vsu.io.bytestream;

/** FileOutputStream
 * Created by vsu on 2017/11/19.
 */


import java.io.FileOutputStream;

/**
 * @Author: vsu
 * @Description: FileOutputStream
 * @Date: 2017/11/19
 */



public class FileOutputStreamTest {
    public static void main(String[] args) {
        io();
    }

    public static void io(){

        try(
                FileOutputStream fileOutputStream = new FileOutputStream("H:\\io\\ioq.txt", true)
        ){

            //一次写入一个字节数组
            fileOutputStream.write("测试 FileOutputStream\r\n".getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
