package com.vsu;

/**
 * Created by vsu on 2017/09/28.
 */




/**
 * @Author: vsu
 * @Descriptioon:  实现对一组无序的字母排序，相同时小写放在前面，要求时间复杂度为o(n)
 * @Date: 2017/09/28
 */


// 首先申请一个长度为52的int数组，按照 aAbB(小写字母保存在下标为偶数的位置，大写字母保存在奇数位置)的顺序
//   依次记录各个字母出现的次数，记录完成后，就可以遍历这个数组按照各个字母出现的次数来重组排序后的数组
public class CharSortTest {

    public static void main(String[] args) {

        char[] src= {'r', 'T', 'd', 'D', 'V', 's', 'd', 'b'};
        sort(src);
        for (char c : src){
            System.out.print(c + " ");
        }

    }

    private static void sort(char[] src){

        if (src == null){
            System.out.println("不合法");
            return;
        }

        //保存52的字符出现的次数
        int[] charCount = new int[52];

        //记录出现次数
        for (char c : src){
            //对小写字母计数
            if (c > 'a' && c < 'z'){
                charCount[(c - 'a') * 2]++;
            }
            //对大写字母计数
            else if (c > 'A' && c < 'Z'){
                charCount[(c - 'A') * 2 + 1]++;
            }
        }

        //生成数组
        int index = 0;
        for (int i=0; i<charCount.length; ++i){
            //这个字符在原始字符串中存在
            if (charCount[i] != 0){
                //小写字母
                if (i % 2 == 0){
                    for (int j=0; j<charCount[i]; ++j){
                        src[index++] = (char) ((i / 2) + 'a');
                    }
                }else{
                    //大写
                    for (int j=0; j<charCount[i]; ++j){
                        src[index++] = (char) ((i - 1) / 2 + 'A');
                    }
                }
            }
        }

    }




}
