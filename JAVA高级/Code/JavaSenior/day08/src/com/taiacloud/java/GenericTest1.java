package com.taiacloud.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法；
 *
 * 1.关于自定义泛型类、泛型接口
 *
 *
 * @author taia
 * @creat 2021-10-23-14:28
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化时没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了带泛型的类，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:Hello");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(123);

        SubOrder1<String> sub2 = new SubOrder1<String>();
        sub2.setOrderT("ooo");
    }

    @Test
    public void test3(){
        //. 泛型不同的引用不能相互赋值。

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

        //不能相互赋值
//        list1 = list2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order1 = new Order<String>();
        Integer arr[] = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order1.copyFromArrayToList(arr);

        System.out.println(list);
    }

}
