package com.vsu.interface_static_method;

/** 接口的默认方法与静态方法
 * Created by vsu on 2017/11/23.
 */


import java.util.function.Supplier;

/**
 * Java 8用默认方法与静态方法这两个新概念来扩展接口的声明
 * 默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。（如果有必要的话，可以覆盖这个默认实现）。
 * 在JVM中，默认方法的实现是非常高效的，并且通过字节码指令为方法调用提供了支持。
 * 尽管默认方法非常强大，但是在使用默认方法时我们需要小心注意一个地方：在声明一个默认方法前，请仔细思考是不是真的有必要使用默认方法，
 *      因为默认方法会带给程序歧义，并且在复杂的继承体系中容易产生编译错误
 */

interface Defaulable {

    default String notRequired() {
        return "Default implementation";
    }
}

class DefaultableImpl implements Defaulable {
}

class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}

interface DefaulableFactory {
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}

public class Test {
    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        System.out.println( defaulable.notRequired() );//Default implementation

        defaulable = DefaulableFactory.create( OverridableImpl::new );
        System.out.println( defaulable.notRequired() );//Overridden implementation
    }
}
