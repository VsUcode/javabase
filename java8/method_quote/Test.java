package com.vsu.method_quote;

/** 方法引用
 * Created by vsu on 2017/11/23.
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。
 * 与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 */


/**
 * 以定义了4个方法的Car这个类作为例子，区分Java中支持的4种不同的方法引用。
 */
class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}
public class Test {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
//        test4();
    }

    static Car car = null;

    /**
     * 第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数
     */
    private static void test1(){
        car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
        System.out.println(cars);
    }

    /**
     *第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
     */
    private static void test2(){
        Arrays.asList(Car.create(Car::new)).forEach( Car::collide );
    }

    /**
     * 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
     */
    private static void test3(){
        Arrays.asList(Car.create(Car::new)).forEach( Car::repair );
    }

    /**
     * 第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
     */
    private static void test4(){
        final Car police = Car.create( Car::new );
        Arrays.asList(police).forEach( police::follow );
    }

}
