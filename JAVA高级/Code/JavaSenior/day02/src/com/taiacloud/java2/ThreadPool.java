package com.taiacloud.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 *
 * 好处：
 *  提高响应速度（减少了创建新线程的时间）
 *  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  便于线程管理
 *   corePoolSize：核心池的大小
 *   maximumPoolSize：最大线程数
 *   keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * 创建多线程有几种方式
 *
 * @author taia
 * @creat 2021-10-14-17:02
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 !=0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性--class java.util.concurrent.ThreadPoolExecutor
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
//        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //2.执行指定的线程的操作，需要提供实现Runnable接口或Collable接口实现类的对象
        service.execute(new NumberThread());//适合于使用Runnable
        service.execute(new NumberThread1());//适合于使用Runnable

//        service.submit(Callable callable);//适合于使用Callable

        //3.关闭连接池
        service.shutdown();






    }
}
