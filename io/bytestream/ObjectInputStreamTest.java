package com.vsu.io.bytestream;

/** ObjectInputStream
 * Created by vsu on 2017/11/20.
 */


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * ObjectInputStream也是一个高级流，对以前使用 ObjectOutputStream 写入的基本数据和对象进行反序列化
 */



public class ObjectInputStreamTest {

    public static void main(String[] args) {
        io();
    }

    public static void io(){

        Person person = null;

        try(
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("H:\\io\\ioq.txt"))
        ){

            person = (Person) objectInputStream.readObject();

            System.out.println(person.getName()); //vsu
            System.out.println(person.getAge()); //21
            System.out.println(person.getSex()); //男

            ArrayList<String> list = person.getOther();
            for (String str : list){
                System.out.println(str);
            }//qwer
            //测试 ObjectOutputStream

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
