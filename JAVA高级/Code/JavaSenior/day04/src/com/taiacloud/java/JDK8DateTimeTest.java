package com.taiacloud.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 *
 * jdk8 中日期时间API的测试
 *
 * @author taia
 * @creat 2021-10-18-16:49
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //存在偏移量
        Date date1 = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date1);//Fri Oct 08 00:00:00 CST 3920
    }

    /*
    * LocalDate\LocalTime\LocalDateTime的使用
    * 说明：
    *   1.LocalDateTime相较于LocalDate\LocalTime，使用频率高一些。
    *   2.类似于Calendar
    * */
    @Test
    public void test1(){

        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2021-10-18
        System.out.println(localTime);//17:21:18.312789200
        System.out.println(localDateTime);//2021-10-18T17:21:18.312789200

        //of():设置指定的年月日时分秒没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        //体现了不可变性
        //withXxx()：设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withMonth(12);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        //体现了不可变性
        //plusXxx():在原有的基础上进行添加操作，有返回值
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
        //minusXxx():在原有的基础上进行减少操作，有返回值
        LocalDateTime localDateTime4 = localDateTime.minusMonths(1);
        System.out.println(localDateTime4);


    }
    /*
    * Instant的使用
    * 类似于java.util.date类
    *
    * */
    @Test
    public void test2(){
        //now():获取标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//本初子午线上的瞬时时间
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取瞬时点对应的毫秒数，示自1970年1月1日0时0分0秒（UTC）开始的毫秒数 -->Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli(毫秒数L)：通过给定的毫秒数，获取Instant实例 -->Date(long millis)
        Instant milli = Instant.ofEpochMilli(1634553135731L);
        System.out.println(milli);
    }

    /*
    * DateTimeFormatter：格式化或解析日期、时间
    * 类似于SimpleDateFormat
    *
    * */
    @Test
    public void test3(){
        //实例化的三种方式
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 --》 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串 --》 日期
        TemporalAccessor parse = formatter.parse("2021-10-18T18:47:02.7327543");
        System.out.println(parse);

//        方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

//        方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //格式化
        String str4 = formatter3.format(LocalDate.now());
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-10-18");
        System.out.println(parse1);


    }

















}
