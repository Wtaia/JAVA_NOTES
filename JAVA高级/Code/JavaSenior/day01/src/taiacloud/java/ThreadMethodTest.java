package taiacloud.java;

/**
 * Thread类的常用方法
 * 1.start():启动当前线程；调用当前线程的run()方法
 * 2.run():通常需要重写Thread类中的此方法，将新建线程所需执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字 或者调用Thread的带参构造器设置线程名
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程A中调用线程B的join()，此时线程A进入阻塞状态，直到线程B完全执行完，线程A结束阻塞状态
 * 8.stop():强制结束线程的生命周期，不建议使用。
 * 9.sleep(long millis):让当前线程“睡眠”指定的millis毫秒数。在指定的时间内，当前线程时阻塞状态
 * 10.isAlive():判断当前线程是否存活。
 *
 *
 *
 * 线程的优先级
 * 1.   MAX_PRIORITY：10
 *      MIN _PRIORITY：1
 *      NORM_PRIORITY：5 //默认
 * 2.如何获取和设置当前线程的优先级
 *  getPriority();//获取
 *  setPriority(int p);//设置
 * 3.说明：线程的优先级并不意味着优先级高的一定要在优先级低的线程之前执行。
 *
 *
 *
 *
 *
 *
 * @author taia
 * @creat 2021-10-12-16:04
 */
class ThDemo3 extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() +":" + i);
            }

//            if(i % 20 == 0){
//                Thread.yield();
//            }
        }
    }

    public ThDemo3(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        ThDemo3 thDemo3 = new ThDemo3("Thread:1");
//        thDemo3.setName("线程一");

        thDemo3.setPriority(Thread.MAX_PRIORITY);
        thDemo3.start();

        //给main线程重新命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//
//            if(i == 20){
//                try {
//                   thDemo3.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }

        System.out.println(thDemo3.isAlive());
    }
}
