package com.taiacloud.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 区分list中的remove(int index)和remove(Object obj)方法
 *
 * @author taia
 * @creat 2021-10-21-19:43
 */
public class ListExer {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//1,2
    }
    private void updateList(List list) {
//        list.remove(2);//按照索引删除
        list.remove(new Integer(2));//删除数据2
    }
}
