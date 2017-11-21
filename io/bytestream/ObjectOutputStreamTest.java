package com.vsu.io.bytestream;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/** ObjectOutputStream
 * Created by vsu on 2017/11/19.
 */


/**
 * 在我们讲解对象输出流和对象输入流之前，我们首先要明确两个概念：
 * 序列化和反序列化：
 * 将一个特定的数据结构转换为一组字节的过程称之为序列化
 * 将一组字节转换为特定的数据结构的过程称之为反序列化
 * 持久化：
 * 将数据写入硬盘长久保存的过程称之为持久化
 */


/**
 * ObjectOutputStream是一个高级流， 将 Java 对象的基本数据类型和图形写入 OutputStream。可以使用 ObjectInputStream 读取（重构）对象。
 * 通过在流中使用文件可以实现对象的持久存储。如果流是网络套接字流，则可以在另一台主机上或另一个进程中重构对象。
 */


/**
 * 注意：只能将支持 java.io.Serializable 接口的对象写入流中。
 * 每个 serializable 对象的类都被编码，编码内容包括类名和类签名、对象的字段值和数组值，以及从初始对象中引用的其他所有对象的闭包。
 */


//Person类实现了Serializable接口,所以该类才能被序列化;反之，如果没有实现该接口的类则不能被序列化。
class Person implements Serializable {
    /**
     * 序列化的ID,只要加了该版本号，在反序列化的时候不论你的类的属性是否改变，只要是版本号不变那么尽可能的兼容新版本。
     * 如果版本号改变了，那么反序列化的过程中就会抛出异常。
     */
    private static final long serialVersionUID = 6871740251451383067L;
    private String name;
    private int age;
    private char sex;
    private ArrayList<String> other;

    public Person(){

    }
    public Person(String name, int age, char sex, ArrayList<String> other) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.other = other;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age)throws Exception {
        this.age = age;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public ArrayList<String> getOther() {
        return other;
    }
    public void setOther(ArrayList<String> other) {
        this.other = other;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}


public class ObjectOutputStreamTest {

    public static void main(String[] args) {
        io();
    }

    public static void io(){

        ArrayList<String> list = new ArrayList<>();
        list.add("qwer");
        list.add("测试 ObjectOutputStream");

        Person person = new Person("vsu", 21, '男', list);

        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("H:\\io\\ioq.txt"))
        ){

            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            /**
             *  sr com.vsu.io.bytestream.Person_]SY膬] I ageC sexL namet Ljava/lang/String;L othert Ljava/util/ArrayList;xp   u7t vsusr java.util.ArrayListx佉櫱a? I sizexp   w   t qwert 娴嬭瘯 ObjectOutputStreamx
             */

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
