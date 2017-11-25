package com.vsu.optional;

/** Java 类库的新特性-- Optional
 * Created by vsu on 2017/11/23.
 */


import java.util.Optional;

/**
 * 臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，
 * Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。
 *
 * Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 */




public class Test {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * Optional类：一个允许为空值，一个不允许为空值。
     */
    private static void test1(){
        Optional< String > fullName = Optional.ofNullable( null );
        //如果Optional类的实例为非空值的话，isPresent()返回true，否则返回false。
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        //为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        //map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        /** out
         * Full Name is set? false
         * Full Name: [none]
         *Hey Stranger!
         */
    }

    /**
     *
     */
    private static void test2(){
        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println();
        /** out:
         * First Name is set? true
         *First Name: Tom
         *Hey Tom!
         */
    }

    }
