package taiacloud.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run（）
 * 3.创建此实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start（） -->启动线程 -->调用当前线程的run() -->调用了Runnable类型的target的run()
 *
 * 比较线程的两种创建方式：开发中，优先选择实现Runnable接口的方式
 * 原因：
 * 1.实现的方式没有类的单继承的局限性
 * 2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系：
 * Thread类本身也是通过实现Runnable接口来创建线程的，public class Thread implements Runnable
 * 相同点：
 * 两种方式都需要重写run方法，将线程要执行的逻辑声明到run（）方法中
 *
 * @author taia
 * @creat 2021-10-12-18:02
 */
//1.创建一个实现了Runnable接口的类
class MThread implements Runnable{
//2.实现类去实现Runnable中的抽象方法：run（）
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建此实现类的对象
        MThread mThread = new MThread();

        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);

        // 5.通过Thread类的对象调用start（） -->启动线程 -->调用当前线程的run() -->调用了Runnable类型的target的run()
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
