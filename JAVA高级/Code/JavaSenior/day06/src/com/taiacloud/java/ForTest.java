package com.taiacloud.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合和数组
 *
 * @author taia
 * @creat 2021-10-21-17:04
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //for(集合中元素的类型 局部变量 ： 集合对象)
        //内部仍然调用的是迭代器
        for (Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int [] arr = new int [] {1,2,3,7,6,5,4};
        //for(数组中元素的类型 局部变量 ： 数组对象)
        for (int i: arr) {
            System.out.println(i);
        }
    }

    //笔试题
    @Test
    public void test3(){
        String [] arr = new String [] {"MM","MM","MM"};

        //方式一：普通for循环赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }
//
//        for(int i = 0;i < arr.length;i++){
//            System.out.println(arr[i]);
//        }//“GG”

        //方式二：foreach循环赋值
        for(String i : arr){
            i = "GG";//修改局部变量不会改变原有数组中的元素
        }

        for(String i : arr){
            System.out.println(i);
        }//"MM"
    }
}
