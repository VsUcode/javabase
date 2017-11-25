package com.vsu.lambda;

/** lambda表达式和functional接口
 * Created by vsu on 2017/11/23.
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式（也称为闭包）是整个Java 8发行版中最受期待的在Java语言层面上的改变，
 *     Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据：函数式程序员对这一概念非常熟悉。
 *
 */




public class Test {

    public static void main(String[] args) {

//        test1();
//        test2();
          test3();
    }

    /**
     * 在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。
     */
    private static void test1(){
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        /**
         * 请注意参数e的类型是由编译器推测出来的。
         * 同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型
         */
        Arrays.asList("a", "b", "c").forEach( (String e) -> System.out.println(e));
        /* out:
         *      a
         *      b
         *      c
         */

        /**
         * 在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。
         */
        Arrays.asList("a", "b", "c").forEach( (String e) -> {
            System.out.println(e);//分号--语句结束
            System.out.println(e);
        });

    }

    /**
     *Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。
     */
    private static void test2(){
        String str = "aaa";
        Arrays.asList("a", "b", "c").forEach( (String e) -> System.out.println(e + str));
    }

    /**
     *Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。
     */
    private static void test3(){
        List<String> list = Arrays.asList("b", "a", "c");
        list.sort( (e1, e2) -> e1.compareTo(e2));
        System.out.println(list);
    }


    /**
     * 语言设计者投入了大量精力来思考如何使现有的函数友好地支持lambda。最终采取的方法是：增加函数式接口的概念。
     * 函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换为lambda表达式。
     * 在实际使用过程中，函数式接口是容易出错的：如有某个人在接口定义中增加了另一个方法，这时，这个接口就不再是函数式的了，并且编译过程也会失败。
     * 为了克服函数式接口的这种脆弱性并且能够明确声明接口作为函数式接口的意图，Java 8增加了一种特殊的注解@FunctionalInterface
     */
    @FunctionalInterface
    interface Method1{
        void method1();

        /**
         * 需要记住的一件事是：默认方法与静态方法并不影响函数式接口的契约，可以任意使用
         */
        default void method2(){}
        static void method3(){}

    }

}
