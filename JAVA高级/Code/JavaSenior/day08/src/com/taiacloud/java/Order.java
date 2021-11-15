package com.taiacloud.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 自定义泛型类
 * @author taia
 * @creat 2021-10-23-14:23
 */
public class Order<T> {//T\E\K\V
    String orderName;
    int orderId;

    //类的内部就可以使用泛型

    T orderT;

    public Order(){

    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    //如下的三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    /*
    *   在类/接口上声明的泛型，在本类或本接口中即代表某种类型，
    * 可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。
    * 但在静态方法中不能使用类的泛型。
    *
    *
    * */
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    //泛型方法：在方法中出现了泛型的结构，泛型的参数与类的泛型没有任何关系
    //泛型方法所属的类是不是泛型类都没关系
    //泛型方法可以声明为静态的，原因：泛型参数是在调用方法时确定的，并非是在实例化时确定的。
    public <E>List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}
