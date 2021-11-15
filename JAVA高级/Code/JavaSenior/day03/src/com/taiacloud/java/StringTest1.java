package com.taiacloud.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * 涉及到String类与其他结构之间的转换
 *
 * @author taia
 * @creat 2021-10-16-18:20
 */
public class StringTest1 {
    /*
    * String 和 byte[] 之间的转换
    * 编码：String---> byte[]:调用String的getBytes()
    * 解码：byte[]--->String：调用String的构造器
    *
    * 编码：字符串--》字节（看得懂---》看不懂的二进制数据）
    * 解码：编码的逆过程，字节---》字符串（看不懂的二进制数据---》看得懂）
    *
    * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
    * */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//ASCLL码值、UTF-8编码，使用默认字符编码转换
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str1.getBytes("GBK");//使用指定编码集转换
        System.out.println(Arrays.toString(bytes1));

        System.out.println("********************");

        String str2 = new String(bytes);//使用默认字符编码转换
        System.out.println(str2);

        String str3 = new String(bytes1);//编码和解码不一致
        System.out.println(str3);

        String gbk = new String(bytes1, "GBK");//指定编码集
        System.out.println(gbk);


    }

    /*
    * String 与 char[] 之间的转换
    *
    * String---> char[]:调用String的toCharArray()
    * char[]--->String:调用String的构造器
    *
    * */
    @Test
    public void test2(){
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int cha = 0; cha < charArray.length; cha++) {
            System.out.println(charArray[cha]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }

    /*
    * 复习：
    *   String 与基本数据类型、包装类之间的转换
    *   String-->基本数据类型、包装类:调用包装类的静态方法：parseXxx(str)
    *   基本数据类型、包装类-->String:调用String重载的valueOf(xxx)
    * */
    @Test
    public void test(){
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);

        System.out.println(String.valueOf(num));
        String str2 = num + "";
        System.out.println(str2);
        System.out.println(str1 == str2);//false

    }




}
