package com.taiacloud.java;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 * 1.集合、数组都是对多个数据进行存储（内存层面，不涉及持久化的存储）操作的结构，简称Java容器。
 * 2.数组在存储多个数据方面的特点：
 *      2.1一旦初始化以后，其长度就确定了。
 *      2.2数组一旦定义好，其元素的类型也就确定了，之后就只能操作指定类型的数据。
 *          如：String [] arr;int [] arr1;Object [] arr2;
 * 3.数组在存储多个数据方面的缺点：
 *      3.1一旦初始化以后，其长度就不可修改了。
 *      3.2数组中提供的方法非常有限，对于添加、删除、插入数据等操作非常不便，同时效率不高。
 *      3.3获取数组中实际元素的个数，数组没有现成的属性或方法可用。
 *      3.4数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，数组无法满足。
 *
 * 二、集合框架
 *      |---Collection接口：单列集合，用来存储一个一个的对象
 *          |---List接口：存储有序的、可重复的数据。---》“动态数组”
 *              |---ArrayList、LinkList、Vector
 *
 *          |---Set接口：存储无序的、不可重复的数据。---》高中讲的“集合”：无序性、确定性、互异性
 *              |---HashSet、LinkHashSet、TreeSet
 *
 *      |---Map接口：双列集合，用来存储一对一对（key -- value）的数据。---》数学的函数：y = f(x)
 *              |---HashMap、LinkHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口中的方法的使用
 *
 *  结论：
 *  向Collection接口的实现类的对象中添加数据obj时，要求obj所在的类要重写equals()
 *
 *
 *
 *
 * @author taia
 * @creat 2021-10-19-20:40
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //1.add(Object e):将元素e添加到集合coll中,只能添加对象
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //2.size():获取添加的元素的个数
        System.out.println(coll.size());

        //3.addAll(Collection coll1):将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //4.clear():清空集合元素
        coll1.clear();

        //5.isEmpty():判断当前集合是否为空
        System.out.println(coll1.isEmpty());
        System.out.println(coll.isEmpty());

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p1 = new Person("Jerry", 20);
        coll.add(p1);

        //1.contains(Object obj):判断当前集合中是否包含obj,判断时调用obj对象所在类的equals()。
        System.out.println(coll.contains(123));//true
        System.out.println(coll.contains(new String("Tom")));//true,调用String重写的equals()方法
        System.out.println(coll.contains(p1));//true

        Person p2 = new Person("Jerry",20);
        System.out.println(coll.contains(p2));//false，Person类中没有重写equals()方法，则调用父类Object中的equals()，就是“==”
                                              //重写后返回true

        //2.containsAll(Collection coll1):判断形参中的所有元素是不是都存在于当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        Collection coll2 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));//true
        System.out.println(coll.containsAll(coll2));//true


    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p1 = new Person("Jerry", 20);
        coll.add(p1);

        //3.remove(Object obj):从当前集合中删除obj元素
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll):从当前元素中移除coll中所有的元素，移除两个集合共有的元素;差集
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);


    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //5.retainAll(Collection coll1):交集，获取当前集合与coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        System.out.println(coll);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合元素都相同。
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry", 20));

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //拓展.数组 ---> 集合：asList():调用Arrays类的静态方法 asList()
        List list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
        List list1 = Arrays.asList(new int[]{123, 456});//asList认为基本数据类型的数组为一个元素，存储的是地址值
        System.out.println(list1);//I@5579bb86
        System.out.println(list1.size());//1
        List list2 = Arrays.asList(new Integer[]{123, 456});//asList认为包装类的数组为多个元素
        System.out.println(list2);//123, 456

        //iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试


    }















}
