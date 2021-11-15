package com.taiacloud.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1.Set接口的框架结构：
 * |---Set接口：存储无序的、不可重复的数据。--->高中讲的“集合”：无序性、确定性、互异性
 *          |---HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值；
 *          |---LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序去遍历；对于频繁的遍历操作，LinkedHashSet效率要高于HashSet；
 *          |---TreeSet：可以按照添加对象的指定属性进行排序；
 *
 * 2.Set接口中没有额外的定义新的方法，使用的都是Collection中声明过的方法。
 * 3.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *         重写的hashCode()和equals()尽可能保持一致：相等的对象必须具有相等的散列码。
 *         重写两个方法时的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 *
 * @author taia
 * @creat 2021-10-21-19:59
 */
public class SetTest {
    /*
    * 一、Set接口：存储无序的、不可重复的数据。
    *   以HashSet为例说明：
    *   1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
    *
    *   2.不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个。
    * 二、添加元素的过程：以HashSet为例：（以链地址法解决冲突的哈希表）
    *   我们向HashSet，中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，此哈希值接着
    * 通过某种算法计算出在HashSet底层数组中的存放位置（即：索引位置），判断数组此位置上是否已经有元素：
    *   若此位置没有元素，则元素a添加成功；
    *   若此位置有其他元素b（或存在以链表形式的多个元素），则比较元素a与元素b的hash值：
    *       如果hash值不相同，则元素a添加成功。--->情况1
    *       如果hash值相同，进而需要调用元素a所在类的equals方法：--->情况2
    *           equals返回true：添加失败
    *           equals返回false：添加成功 --->情况3
    *       对于添加成功的情况2和情况3而言：元素a与已存在指定索引位置上的数据以链表的方式存储。
    *           jdk7，元素a放到数组中，指向原来的元素。
    *           jdk8，原来的元素在数组中，指向元素a。
    *           总结：7上8下
    *
    *       HashSet底层：数组+链表的结构
    *
    * */
    @Test
    public void test1(){
        Set set = new HashSet();//创建一个长度为16的数组
        set.add(456);//添加元素时随机存放
        set.add(123);
//        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    * LinkedHashSet的使用：
    *   LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个指针，
    *   记录此数据前一个数据和后一个数据。
    *   优点：对于频繁的遍历操作，LinkedHashSet效率要高于HashSet
    *
    * */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
//        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
