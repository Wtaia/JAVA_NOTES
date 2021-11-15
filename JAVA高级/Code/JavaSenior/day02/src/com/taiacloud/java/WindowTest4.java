package com.taiacloud.java;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * @author taia
 * @creat 2021-10-13-19:14
 */
public class WindowTest4 {
    public static void main(String[] args) {

        Window4 windows1 = new Window4();
        Window4 windows2 = new Window4();
        Window4 windows3 = new Window4();

        windows1.setName("窗口一：");
        windows2.setName("窗口二：");
        windows3.setName("窗口三：");

        windows1.start();
        windows2.start();
        windows3.start();

    }
}

class Window4 extends Thread {
    private static int num = 100;

    @Override
    public void run() {
        while (true) {

            show();
        }


    }

    private static synchronized void show() {//把show方法声明为静态的，默认同步监视器为当前的类，当前的类是唯一的-->正确
//    private synchronized void show(){//默认同步监视器：this-->windows1，windows2，windows3。错误
        if (num > 0) {

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            System.out.println(Thread.currentThread().getName() + "卖票一张,票号为：" + num);
            num--;
        }
    }
}




