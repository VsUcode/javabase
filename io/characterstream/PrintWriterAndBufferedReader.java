package com.vsu.io.characterstream;

/** 使用PrintWriter/BufferedReader实现文件的复制
 * Created by vsu on 2017/11/19.
 */


import java.io.*;
import java.util.regex.Pattern;

/**
 * @Author: vsu
 * @Description: 由于BufferedWriter没有PrintWriter使用灵活，所以在实际的操作中，我们往往会使用PrintWriter/BufferedReader这种组合。
 * @Date: 2017/11/19
 */
public class PrintWriterAndBufferedReader {

    public static void main(String[] args) {
        copy();
    }

    public static void copy(){

        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\io\\io.txt")));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("H:\\io\\ioq.txt", true)))
        ){

            String line = null;
            while ( (line = bufferedReader.readLine()) != null){
                printWriter.println(line);
            }
            printWriter.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
