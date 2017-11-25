package com.vsu.parallel;

/** 并行（parallel）数组
 * Created by vsu on 2017/11/23.
 */


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Java 8增加了大量的新方法来对数组进行并行处理。
 * 可以说，最重要的是parallelSort()方法，因为它可以在多核机器上极大提高数组排序的速度
 */



public class Test {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 使用了parallelSetAll()方法来对一个有20000个元素的数组进行随机赋值。
     * 然后，调用parallelSort方法。这个程序首先打印出前10个元素的值，之后对整个数组排序。
     */
    private static void test1(){
        long[] arrayOfLong = new long [ 20000 ];

        Arrays.parallelSetAll( arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();//485591 532442 497767 688281 294040 424420 90880 719456 622916 242352

        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();//100 141 219 226 229 336 416 448 462 476

    }
}
