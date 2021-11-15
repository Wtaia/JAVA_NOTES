package com.taiacloud.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * jdk 8.0之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author taia
 * @creat 2021-10-18-15:19
 */
public class DateTimeTest {
    /*
    * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    *
    *   1.两个操作：
    *       1.1格式化：日期 ---> 字符串
    *       1.2解析：格式化的逆过程，字符串 ---> 日期
    *   2.SimpleDateFormat的实例化
    *
    *
    * */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //SimpleDateFormat的实例化:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
//        System.out.println(date);//Mon Oct 18 15:28:53 CST 2021
        String format = sdf.format(date);//转化为字符串
        System.out.println(format);//2021/10/18 下午3:36

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "2021/10/18 下午3:36";
        Date date1 = sdf.parse(str);
        System.out.println(date1);


        //***************按照指定的方式格式化和解析：调用带参的构造器*******************
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = sdf2.format(date);
        System.out.println(format2);
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式的格式（通过构造器参数体现），否则会抛异常
        Date date2 = sdf2.parse("2021-10-18 03:44:41");
        System.out.println(date2);

    }

    /*
     * 练习一：字符串“2020-09-08”转换为java.sql.Date
     *
     * 练习二：“三天打鱼两天晒网” 1990-01-01  问：xxxx-xx-xx是在打鱼还是晒网
     *
     *  总天数 % 5 == 1，2，3：打渔；
     *  总天数 % 5 == 4，0：晒网；
     *
     *  总天数的计算？
     *      方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     *      方式二：1990 - 01- 01 ---> 2019-12-31 + 2020-01-01 ---> 2021 - 10- 18
     * */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat birthFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = birthFormat.parse(birth);
        System.out.println(date);
        //java.util.Date转化为java.sql.Date：调构造器
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

    }

    /*
    * Calendar日历类（抽象类）的使用
    *
    *
    *
    * */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//java.util.GregorianCalendar

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set():直接改变对象的属性,calendar是可变的
        calendar.set(Calendar.DAY_OF_YEAR,22);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //add()
        calendar.add(Calendar.DAY_OF_YEAR,3);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //getTime():日历类转化为Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date转化为日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        int days1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days1);


    }















}
