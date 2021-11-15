package com.taiacloud.java;

/**
 *  例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 *  存在线程安全问题，待解决
 *
 *  1.问题：卖票过程中出现重票和错票--线程安全问题
 *  2.问题出现的原因：当某个线程执行过程中，尚未完成，其他线程参与进来，同时操作导致的
 *  3.如何解决：当一个线程在操作共享数据时，其他线程不能参与进来，直到当前线程操作结束后，
 *      其他线程才能继续操作，即使该线程出现阻塞状态，也不能改变
 *  4.在Java中，我们通过同步机制，来解决线程的安全问题
 *
 *      方式一：同步代码块
 *          synchronized(同步监视器){
 *              //需要被同步的代码
 *          }
 *          说明：1.操作共享数据的代码，即为需要被同步代码
 *               2.共享数据：多个线程共同操作的变量
 *               3.同步监视器，俗称：锁。
 *                  任何一个类的对象都可以充当锁
 *                  要求：**多个线程必须要共用同一把锁**
 *          补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this来充当同步监视器
 *               在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类来充当同步监视器
 *
 *
 *      方式二：同步方法
 *          如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的
 *          总结：
 *              1.同步方法仍然涉及到同步监视器，只是不需要显式的声明
 *              2.非静态的同步方法，同步监视器：this
 *                静态的同步方法，同步监视器：当前类本身
 *
 *
 *  5.同步的方式，解决了线程的安全问题。 ---好处
 *    操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低 ---局限性
 *
 *
 *
 *
 * @author taia
 * @creat 2021-10-12-19:30
 */
class Window1 implements Runnable{
    private int ticket = 100;
//    Object obj = new Object();
    Dog dog = new Dog();
    @Override
    public void run() {
        while (true){
            synchronized (this){//此时的this：唯一的window1的对象
                // 方式二：synchronized (dog) {
                if (ticket > 0) {

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Dog{

}
