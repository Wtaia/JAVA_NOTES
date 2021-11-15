package com.taiacloud.java;

import org.junit.Test;

import java.util.Date;

/**
 *
 * JDK 8之前日期和时间API测试
 *
 * @author taia
 * @creat 2021-10-16-20:58
 */
public class DateTimeTest {
    /*
    * java.util.Date类
    *   |---java.sql.Date类
    *
    * 1.两个构造器的使用
    *       构造器一：Date()：创建一个对应当前时间的Date对象
    *       构造器二：创建指定毫秒数的Date对象
    *
    * 2.两个方法的使用
    *       >toString(): 显示当前的年月日时分秒
    *       >getTime():获取当前Date对象对应的时间戳，毫秒数，当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
    * 3.java.sql.Date对应着数据库中的日期类型的变量
    *       >如何实例化
    *       >sql.Date --> util.Date 对象：直接赋值（多态，子父类的关系）
    *       >util.Date --> sql.Date 对象：
    * */
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun Oct 17 11:08:07 CST 2021
        System.out.println(date1.getTime());//1634440199583


        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1634440199583L);
        System.out.println(date2);


        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1634440199583L);
        System.out.println(date3);

        //util.Date --> sql.Date 对象
        //情况一
        Date date4 = new java.sql.Date(1634440199583L);//多态
        java.sql.Date date5 = (java.sql.Date)date4;
        System.out.println(date4);
        System.out.println(date5);
        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);

    }


    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){

        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }
}
