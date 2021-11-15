package com.taiacloud.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *
 *
 *
 *
 * @author taia
 * @creat 2021-10-23-18:29
 */
public class GenericTest {
    /**
     * 泛型在继承方面的体现
     *      虽然类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系。
     *      补充：类A是类B的父类，A<G> 是 B<G> 的父类。
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2类型不具有子父类关系
        //编译不通过
//        list1 = list2;

        /*
        * 反证法：
        *   假设list2可以赋给list1
        *   list1.add(123);导致混入非String的数据，出错
        *
        * */

        show(list1);
        //编译不通过
        show1(list2);

    }

    public void show(List<Object> list){

    }
    public void show1(List<String> list){

    }

    @Test
    public void test2(){
        List<String> list1 = null;
        ArrayList<String> list2 = null;

        list1 = list2;
    }

    /**
     * 通配符的使用
     *  通配符：?
     *  类A是类B的父类，G<A> 和 G<B> 二者是没有关系的并列的类，二者共同的父类是：G<?>
     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        //list为list1和list2的通用父类
        List<?> list = null;
        list = list1;
        list = list2;

//        print(list1);
//        print(list2);

        //
        List<String> list3 = new ArrayList<String>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加:对于List<?>就不能向其内部添加元素
        //除了添加null
//        list.add("DD");
        list.add(null);

        //获取：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


    /**
     * 有限制条件的通配符
     *  ? extends A;
     *      G<? extends A> 可以作为G（A）和G（B）的父类，其中B是A的子类
     *  ? super A;
     *      G<? super A> 可以作为G（A）和G（B）的父类，其中B是A的父类
     */

    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;
        //extends ----> "<="
        list1 = list3;
        list1 = list4;
//        list1 = list5;

        //super ----> ">="
//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据没有问题
        //写入数据：extends不行，super可以。
    }
}
