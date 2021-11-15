package taiacloud.java;

/**
 * 多线程的创建
 * 方式一：继承Thread类
 * 1.创建一个继承与Thread类的子类
 * 2.重写Thread类的run（）方法 --> 将此线程执行的操作声明到run（）方法中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start（）方法:1.启动当前线程 2.调用当前线程的run方法
 *
 * 例子：遍历100以内的所有偶数
 *
 *
 *
 *
 * @author taia
 * @creat 2021-10-12-10:04
 */

//1.创建一个继承与Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run（）方法
    @Override
    public void run() {
        // 例子：遍历100以内的所有偶数
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
// 3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //4.通过此对象调用start（）方法
        myThread.start();
//        myThread.run();
        //问题一：直接调用run（）方法执行的仍然是main线程，不会新建线程


        //问题二：再启动一个线程，遍历100以内的偶数。一个线程不可以重复调用。
        //  创建新线程需要新建对象调用start（）
        MyThread myThread1 = new MyThread();
        myThread1.start();


        //如下操作依然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }


    }
}
