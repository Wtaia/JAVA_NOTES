package com.taiacloud.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用：
 * 1.jdk 5.0 新增的特性
 * 2.在集合中使用泛型：
 *  总结：
 *      集合接口或集合类在jdk5.0的时候都修改为带泛型的结构；
 *      在实例化集合类时，可以指明具体的泛型类型
 *      指明之后，在集合类或接口中，凡是定义类或接口时，内部结构(比如：方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化的泛型类型
 *          比如:add(E e) ---> 实例化以后：add(Integer e)
 *      注意：泛型的类型必须是一个类，不能是基本数据类型，需要用到基本数据类型的位置，用包装类替换
 *      如果，实例化时没有指明泛型的类型，默认类型为java.lang.Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法；见GenericTest1.
 *      异常类，不能声明为泛型类。
 *
 *
 * @author taia
 * @creat 2021-10-23-12:35
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();

        //需求：存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        list.add(100);

        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list){
            //问题二：强转时，可能出现classCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况:以ArrayList举例
    @Test
    public void test2(){
        //泛型的类型不能是基本数据类型
//        ArrayList<Integer> list = new ArrayList<Integer>();
        //jdk7新特性：类型推断
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);

        //编译时，会进行类型检查，保证类型安全
//        list.add("AA");

        //方式一：增强for循环
//        for (Integer score : list) {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：迭代器
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("AA",87);
        map.put("BB",100);
        map.put("CC",66);

//        map.put(123,123);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "======" + value);
        }
    }

}
