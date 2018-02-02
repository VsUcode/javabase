package com.vsu;

/**
 * Created by vsu on 2017/10/02.
 */

/**
 * @Author: vsu
 * @Descriptioon: Java中静态代码块、构造代码块的区别
 * @Date: 2017/10/02
 */


/**静态代码块、构造代码块、构造函数同时存在时的执行顺序：静态代码块 > 构造代码块  > 构造函数；
 *  直接在类中定义且没有加static关键字的代码块称为{}构造代码块。
 *  构造代码块在创建对象时被调用，每次创建对象都会被调用，并且构造代码块的执行次序优先于类构造函数。
 *  静态代码块:在java中使用static关键字声明的代码块。静态块用于初始化类，为类的属性初始化。每个静态代码块只会执行一次。由于JVM在加载类时会执行静态代码块，所以静态代码块先于主方法执行。
 *  注意：1 静态代码块不能存在于任何方法体内。2 静态代码块不能直接访问静态实例变量和实例方法，需要通过类的实例对象来访问。
 */



public class StaticFTest {

    /*************************************
    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块，在类中定义");
    }

    public StaticFTest() {
        System.out.println("构造方法执行");
    }

    public static void main(String[] args) {

        new StaticFTest();
        new StaticFTest();
        /*
            静态块
            构造块，在类中定义
            构造方法执行
            构造块，在类中定义
            构造方法执行
         */


    /******************************************
    //普通代码块和一般的语句执行顺序由他们在代码中出现的次序决定--“先出现先执行”
    public static void main(String[] args) {
        {
            int x = 3;
            System.out.println("1,普通代码块内的变量x=" + x);
        }
        int x = 1;
        System.out.println("主方法内的变量x=" + x);
        {
            int y = 7;
            System.out.println("2,普通代码块内的变量y=" + y);
        }

        /*
        1,普通代码块内的变量x=3
        主方法内的变量x=1
        2,普通代码块内的变量y=7
        */


    /*************************************************
    /*静态代码块:在java中使用static关键字声明的代码块。
        静态块用于初始化类，为类的属性初始化。
        每个静态代码块只会执行一次。
        由于JVM在加载类时会执行静态代码块，所以静态代码块先于主方法执行。
        如果类中包含多个静态代码块，那么将按照"先定义的代码先执行，后定义的代码后执行"。
        注意：1 静态代码块不能存在于任何方法体内。
        2 静态代码块不能直接访问静态实例变量和实例方法，需要通过类的实例对象来访问。
    class Code {
        {
            System.out.println("Code的构造块");
        }
        static {
            System.out.println("Code的静态代码块");
        }
        public Code() {
            System.out.println("Code的构造方法");
        }
    }
    public class Test {
        {
            System.out.println("Test的构造块");
        }
        static {
            System.out.println("Test的静态代码块");
        }
        public Test() {
            System.out.println("Test的构造方法");
        }
        public static void main(String[] args) {
            System.out.println("Test的主方法");
            new Code();
            new Code();
            new Test();
            new Test();
        }
    }
        /*
        Test的静态代码块
        Test的主方法
        Code的静态代码块
        Code的构造块
        Code的构造方法
        Code的构造块
        Code的构造方法
        Test的构造块
        Test的构造方法
        Test的构造块
        Test的构造方法
         */

    }
}
