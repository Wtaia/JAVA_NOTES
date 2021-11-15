package com.taiacloud.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet：可以按照添加对象的指定属性进行排序；(底层为二叉排序树---->红黑树)
 *  1.向TreeSet中添加的数据，要求是相同分类的对象。
 *  2.两种排序方式：自然排序(实现Comparable接口)和定制排序(Comparator接口)。
 *  3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
 *  4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
 *
 * @author taia
 * @creat 2021-10-22-15:47
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //不能添加不同类的对象，执行失败
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));


        //举例一：数字按照从小到大排序
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列，年龄一样不要了
            //年龄一样的要先执行的，舍弃后添加的，先来后到
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入的类型不匹配");
                }
            }
        };



        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",12));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }
}
