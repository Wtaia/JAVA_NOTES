package com.taiacloud.java;

/**
 * 商品类
 * @author taia
 * @creat 2021-10-18-19:57
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {

    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    //指明商品比较大小的方式:按价格从低到高，再按照产品名称从低到高排序
    public int compareTo(Object o) {
        //方式一
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //一级排序
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                //二级排序
                return this.name.compareTo(goods.name);
            }

            //方式二：包装类的Compare方法
//            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");

    }

    ////指明商品比较大小的方式:按照产品名称从高到低排序，再按价格从高到低
}
