package com.taiacloud.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较 == 或 ！= ，不能使用 > 或 < d的
 *          但是在开发的场景中，我们需要对多个对象进行排序。需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个：Comparable或Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *      Comparable接口一旦指定可以保证，接口实现类的对象在任何位置都可以比较大小。
 *      Comparator接口属于临时性的比较。
 *
 *
 * @author taia
 * @creat 2021-10-18-19:24
 */
public class CompareTest {
    /*
    * Comparable接口的使用举例：自然排序
    *   1.String类、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式。
    *   2.String类、包装类等重写compareTo()方法以后，进行了从小到大的排列
    *   3.重写了compareTo(obj)方法的规则：如果当前对象this大于形参对象obj，则返回正整数，
    *   如果当前对象this小于形参对象obj，则返回负整数，如果当前对象this等于形参对象obj，则返回零。
    *   4.对于自定义类，如果需要排序，我们可以让日定义类实现Comparable接口，重写CompareTo方法，
    *   在compareTo方法中指明如何排序
    * */

    @Test
    public void test1(){
        String[] arr = new String[]{"FF","GG","CC","EE","DD","AA","BB"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods [] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("DellMouse",43);
        arr[2] = new Goods("MiMouse",3);
        arr[3] = new Goods("HuaWeiMouse",39);
        arr[4] = new Goods("AppleMouse",39);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
    /*
    * Comparator接口的使用：定制排序
    * 1.背景：
    *       当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    *   或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    *   那么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。
    * 2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
    *   如果方法返回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，
    *   表示o1小于o2。
    *
    *
    * */

    @Test
    public void test3(){
        String[] arr = new String[]{"FF","GG","CC","EE","DD","AA","BB"};
        Arrays.sort(arr, new Comparator<String>() {
            //按照字符串从大到小的顺序排序
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test4(){
        Goods [] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("DellMouse",43);
        arr[2] = new Goods("MiMouse",3);
        arr[3] = new Goods("HuaWeiMouse",39);
        arr[4] = new Goods("AppleMouse",39);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从高到低排序，再按价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return -g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入数据错误");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}
