package com.taiacloud.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 *  存在线程安全问题待解决
 *
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 *
 *
 * @author taia
 * @creat 2021-10-12-17:23
 */
public class WindowTest2 {


    public static void main(String[] args) {

        Window2 windows1 = new Window2();
        Window2 windows2 = new Window2();
        Window2 windows3 = new Window2();

        windows1.setName("窗口一：");
        windows2.setName("窗口二：");
        windows3.setName("窗口三：");

        windows1.start();
        windows2.start();
        windows3.start();

    }

}


class Window2 extends Thread{
    private static int num = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //正确的
//            synchronized (obj){
            //错误的
//            synchronized (this){
            //类也是对象--》Class clazz = Window2.class-->Window2.class只会加载一次
            synchronized (Window2.class){
                if(num > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票一张,票号为：" + num );
                    num--;
                }else{
                    break;
                }
            }

        }
    }
}
