package com.taiacloud.java;

import java.util.Arrays;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author taia
 * @creat 2021-10-19-15:53
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():
        System.out.println(summer.toString());
//        System.out.println(Season1.class.getSuperclass());

        //values():
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));

        Thread.State[] states = Thread.State.values();//线程的状态枚举类
        System.out.println(Arrays.toString(states));

        //valueOf(string Obj):根据提供的objName，返回枚举类中对象名是objName的对象，若没有名为objName的对象则抛出异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);


        //
        winter.show();


    }
}

interface  Info{
    void show();
}


//使用enum关键字定义枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的多个对象,多个对象之间用逗号隔开，末尾对象分号结束
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("这是一个春天");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("这是一个夏天");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("这是一个秋天");
        }
    },
    WINTER ("冬天","白雪皑皑"){
        @Override
        public void show() {
            System.out.println("这是一个冬天");
        }
    };


    //2.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    //4.其他诉求1：获取枚举类对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }

    //5.其他诉求2：如果不重写toString()，默认toString()输出常量名


}
