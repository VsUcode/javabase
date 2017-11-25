package com.vsu.compiler;

/** Java编译器的新特性 -- 参数名字
 * Created by vsu on 2017/11/23.
 */


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 很长一段时间里，Java程序员一直在发明不同的方式使得方法参数的名字能保留在Java字节码中，并且能够在运行时获取它们（比如，Paranamer类库）。
 * 最终，在Java 8中把这个强烈要求的功能添加到语言层面（通过反射API与Parameter.getName()方法）与字节码文件（通过新版的javac的–parameters选项）中。
 */


public class Test {
    public static void main(String[] args) throws Exception{
        Method method = Test.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );
        }
        /**
         * 如果不使用–parameters参数来编译这个类，然后运行这个类，会得到下面的输出：
         *     Parameter: arg0
         *
         * 如果使用–parameters参数来编译这个类，程序的结构会有所不同（参数的真实名字将会显示出来）：
         *     Parameter: args
         */
    }
}
