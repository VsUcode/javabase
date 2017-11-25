package com.vsu.date_time;

/** Java 类库的新特性-- Date
 * Created by vsu on 2017/11/23.
 */


import java.time.*;

/**
 * ava 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。对日期与时间的操作一直是Java程序员最痛苦的地方之一。
 * 标准的 java.util.Date以及后来的java.util.Calendar一点没有改善这种情况（可以这么说，它们一定程度上更加复杂）。
 */



public class Test {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }


    static final Clock clock = Clock.systemUTC();

    /**
     * 第一个是Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
     * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
     */
    private static void test1(){
        System.out.println( clock.instant() );//2017-11-23T14:20:45.075Z
        System.out.println( clock.millis() );//1511446845167
    }

    /**
     * 我们需要关注的其他类是LocaleDate与LocalTime。LocaleDate只持有ISO-8601格式且无时区信息的日期部分。
     * 相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间部分。LocaleDate与LocalTime都可以从Clock中得到。
     */
    private static void test2(){
        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now( clock );

        System.out.println( date );//2017-11-23
        System.out.println( dateFromClock );////2017-11-23

       // Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now( clock );

        System.out.println( time );//22:24:24.523
        System.out.println( timeFromClock );//14:24:24.523
    }

    /**
     * LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间。
     */
    private static void test3(){
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );

        System.out.println( datetime );//2017-11-23T22:27:27.124
        System.out.println( datetimeFromClock );//2017-11-23T14:27:27.125

    }

    /**
     * 如果你需要特定时区的日期/时间，那么ZonedDateTime是你的选择。它持有ISO-8601格式具具有时区信息的日期与时间。
     */
    private static void test4(){
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );

        System.out.println( zonedDatetime );//2017-11-23T22:30:14.386+08:00[Asia/Shanghai]
        System.out.println( zonedDatetimeFromClock );//2017-11-23T14:30:14.386Z
        System.out.println( zonedDatetimeFromZone );//2017-11-23T06:30:14.388-08:00[America/Los_Angeles]
    }

    /**
     * 让我们看一下Duration类：在秒与纳秒级别上的一段时间。Duration使计算两个日期间的不同 变的十分简单
     */
    private static void test5(){
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2016, Month.NOVEMBER, 23, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2017, Month.NOVEMBER, 23, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );//Duration in days: 365
        System.out.println( "Duration in hours: " + duration.toHours() );//Duration in hours: 8783

    }


}
