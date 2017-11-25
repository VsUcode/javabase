package com.vsu.stream;

/** Java 类库的新特性-- stream
 * Created by vsu on 2017/11/23.
 */


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 最新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
 * 这是目前为止对Java类库最好的补充，因为Stream API可以极大提供Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * Stream API极大简化了集合框架的处理（但它的处理的范围不仅仅限于集合框架的处理，这点后面我们会看到）
 */



public class Test {
    private enum Status {
        OPEN, CLOSED
    };

    /**
     * Task类有一个分数的概念（或者说是伪复杂度），其次是还有一个值可以为OPEN或CLOSED的状态.
     */
    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }




    public static void main(String[] args) {
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );

//        test1(tasks);
//        test2(tasks);
//        test3(tasks);
//        test4(tasks);
        test5();
    }

    /**
     *第一个问题是所有状态为OPEN的任务一共有多少分数？在Java 8以前，一般的解决方式用foreach循环，
     * 但是在Java 8里面我们可以使用stream：一串支持连续、并行聚集操作的元素。
     */
    private static void test1(Collection<Task> tasks){
        final long totalPointsOfOpenTasks = tasks
                .stream()//task集合被转换化为其相应的stream表示
                .filter( task -> task.getStatus() == Status.OPEN )//filter操作过滤掉状态为CLOSED的task。
                .mapToInt( Task::getPoints )//mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream
                .sum();//用sum函数把所有的分数加起来，得到最终的结果。

        System.out.println( "Total points: " + totalPointsOfOpenTasks );//Total points: 18

        /**
         *  .stream操作被分成了中间操作与最终操作这两种。
         *
         *  中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，运行一个像filter这样的中间操作实际上没有进行任何过滤，
         *      相反它在遍历元素时会产生了一个新的stream对象，这个新的stream对象包含原始stream中符合给定谓词的所有元素。
         *
         *  像forEach、sum这样的最终操作可能直接遍历stream，产生一个结果或副作用。当最终操作执行结束之后，stream管道被认为已经被消耗了，没有可能再被使用了
         *      在大多数情况下，最终操作都是采用及早求值方式，及早完成底层数据源的遍历。
         *
         */
    }

    /**
     *  stream另一个有价值的地方是能够原生支持并行处理
     *  这个例子和第一个例子很相似，但这个例子的不同之处在于这个程序是并行运行的，其次使用reduce方法来算最终的结果。
     */
    private static double test2(Collection<Task> tasks){
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map( task -> task.getPoints() ) // or map( Task::getPoints )
                .reduce( 0, Integer::sum );

        System.out.println( "Total points (all tasks): " + totalPoints );//Total points (all tasks): 26.0
        return totalPoints;
    }

    /**
     * 经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求
     */
    private static void test3(Collection<Task> tasks){
        final Map< Status, List< Task >> map = tasks
                .stream()
                .collect( Collectors.groupingBy( Task::getStatus ) );
        System.out.println( map );//{OPEN=[[OPEN, 5], [OPEN, 13]], CLOSED=[[CLOSED, 8]]}
    }

    /**
     *让我们来计算整个集合中每个task分数（或权重）的平均值来结束task的例子。
     */
    private static void test4(Collection<Task> tasks){
        double totalPoints = test2(tasks);//Total points (all tasks): 26.0

        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
                .collect( Collectors.toList() );                 // List< String > 

        System.out.println( result );//[19%, 50%, 30%]
    }

    /**
     * 就像前面提到的，Stream API不仅仅处理Java集合框架。像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理。
     */
    private static void test5(){
        String filename = null;//此处未写
        final Path path = new File( filename ).toPath();
        try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
            lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
            //onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，当对stream对象调用close()方法时，与关闭相关的处理器就会执行。

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
