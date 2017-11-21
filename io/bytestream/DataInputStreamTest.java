package com.vsu.io.bytestream;

/** DataInputStream DataOutputStream
 * Created by vsu on 2017/11/19.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * DataInputStream和DataOutputStream二者分别实现了DataInput/DataOutput接口
 * DataInputStream能以一种与机器无关（当前操作系统等）的方式，直接从地从字节输入流读取JAVA基本类型和String类型的数据，常用于网络传输等（网络传输数据要求与平台无关）
 */

public class DataInputStreamTest {

    public static void main(String[] args) {

        //ioWrite();
        ioRead();
    }

    public static void ioWrite(){
        try(
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("H:\\io\\ioq.txt"))
        ){

           dataOutputStream.writeInt(2);
           dataOutputStream.writeUTF("测试 DataOutputStream");

            /**
             *     测试 DataOutputStream
             */
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void ioRead(){

        try(
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("H:\\io\\ioq.txt"))
        ){

            System.out.println(dataInputStream.readInt()); //2
            System.out.println(dataInputStream.readUTF()); //测试 DataOutputStream

            /**
             *
             */
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
