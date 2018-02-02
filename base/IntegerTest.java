package com.vsu;

/**
 * Created by vsu on 2017/10/02.
 */

/**
 * 如果面试官问Integer与int的区别：估计大多数人只会说道两点，Ingeter是int的包装类，int的初值为0，Ingeter的初值为null。
 *
 */



/**
 * @Author: vsu
 * @Descriptioon: int 和 Integer的区别
 * @Date: 2017/10/02
 */
public class IntegerTest {

    public static void main(String[] args) {

        //int和Integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println(i == i2);//true
        System.out.println(i == i3);//true


        //两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false
        //java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);//true
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);//false


        //无论如何，Integer与new Integer不会相等。不会经历拆箱过程，i9的引用指向堆，而i10指向专门存放他的内存（常量池），他们的内存地址不一样，所以为false
        Integer i9 = new Integer(127);
        Integer i10 = 127;
        System.out.println(i9 == i10); //false


        //两个都是new出来的,都为false
        Integer i11 = new Integer(128);
        Integer i12 = new Integer(123);
        System.out.println(i11 == i12);  //false
    }
}


/**public static Integer valueOf(int i) {
 assert IntegerCache.high >= 127;
 if (i >= IntegerCache.low && i <= IntegerCache.high)
 return IntegerCache.cache[i + (-IntegerCache.low)];
 return new Integer(i);
 }
 *对于-128到127之间的数，会进行缓存，Integer i5 = 127时，会将127进行缓存，下次再写Integer i6 = 127时，就会直接从缓存中取，就不会new了。
 *
 */