package com.taiacloud.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1.list接口框架
 *      |---Collection接口：单列集合，用来存储一个一个的对象
 *          |---List接口：存储有序的、可重复的数据。---》“动态数组”，替换原有的数组
 *              |---ArrayList
 *              |---LinkList
 *              |---Vector
 *
 * 2.list接口的三个实现类的异同
 * 面试题：ArrayList、LinkList、Vector三者的异同？
 *  相同：三个类都实现了List接口，存储数据的特点相同：有序的、可重复的数据。
 *  不同：|---ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData 存储；
 *        |---LinkList：底层使用双向链表进行存储；对于频繁的插入和删除操作，使用此类效率比ArrayList高；
 *        |---Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData 存储；
 *
 *
 * 3.ArrayList的源码分析：
 *      3.1.jdk 7
 *          ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组 elementData
 *          list.add(123);//elementData[0] = new Integer(123);
 *          ......
 *          list.add(11);
 *          //如果此次添加导致底层elementData数组容量不够，则扩容，默认情况下，扩容为原来数组长度的1.5倍，同时需要将原数组中的数据复制到新的数组中
 *
 *          结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);
 *      3.2.jdk 8
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *          list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData的第一个位置
 *          ......
 *          //后续的添加和扩容与jdk7中一样
 *
 *      3.3.小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式。
 *          延迟了数组的创建，节省了内存。
 *
 * 4.LinkedList的源码分析：
 *      LinkedList list = new LinkList();//内部声明了Node类型的first和last属性，默认值为null
 *      list.add();//将123封装到Node中，创建了Node对象。
 *
 *      其中，Node定义为：体现了LinkList的双向链表的结构。
 *
 * 5.Vector的源码分析：
 *      jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组；
 *      扩容的方式和ArrayList不同：默认扩容为原来的二倍；
 *      关于ArrayList线程不安全的问题，通常也不用Vector，而是使用Collections工具类中的工具将ArrayList转化为线程安全的。
 *
 *
 * 6.List接口中的常用方法
 *      增：add(Object obj)
 *      删：remove(int index)  (区别于remove(object obj)----Collection里的)
 *      改：set(int index,Object ele)
 *      查：get(index)
 *      插入：add(int index,Object ele)
 *      长度：size()
 *      遍历：1.Iterator迭代器方式  2.增强for循环  3.普通的循环
 *
 * @author taia
 * @creat 2021-10-21-17:32
 */
public class ListTest {

    /*
        void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
    */
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
        //方式二：增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("*****************");
        //方式三：普通循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在则返回-1；
        System.out.println(list.indexOf(4567));

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置,如果不存在则返回-1；
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开的子集合,不会改变原来的集合
        List list1 = list.subList(2, 4);
        System.out.println(list1);
        System.out.println(list);

    }


    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(0,"BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());//9

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(2));


    }














}
