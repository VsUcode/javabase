package com.vsu.io.characterstream;

/** PrintWriter使用
 * Created by vsu on 2017/11/19.
 */


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @Author: vsu
 * @Description:  PrintWriter的使用
 * @Date: 2017/11/19
 *
 *
 * PrintWriter:是具有自动行刷新的缓冲字符输出流，这是一个高级流。
 * 所谓的自动行刷新，意思就是说：在构造函数中指定autoFlush的值为true时，则 println()、printf() 或 format() 方法将自动刷新输出缓冲区(自动调用flush()方法)，但是,自动行刷新无疑会增加写出次数而降低写出效率。
 * 由于BufferedWriter没有PrintWriter使用灵活，所以在实际的操作中，我们往往会使用PrintWriter/BufferedReader这种组合。
 */



public class PrintWriterTest {

    public static void main(String[] args) {

        io();
    }

    public static void io(){

        //打开文件
        // 采用try with resource 自动关闭流
        try (
                // 看提示 "UTF-8"可以不写 因为默认就是这个编码
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("H:\\io\\ioq.txt", true), "UTF-8"), true)
        ){
            printWriter.append("qewr\r\n");
            printWriter.write("asdfg\r\n");
            printWriter.println("测试 PrintWriter\r\n");
            /**
             *  \r ： return 到当前行的最左边。
             *  \n： newline 向下移动一行，并不移动左右。
             *   Linux中\n表示回车+换行；
             *  Windows中\r\n表示回车+换行。
             *  Mac中\r表示回车+换行。
             *  在windows中换行是\n\r,\n表示换行，\r表示回车，\r和一种老式打印机有关。
             *  在unix和Linux中换行是\n。
             */

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
