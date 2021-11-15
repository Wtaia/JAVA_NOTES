package taiacloud.exer;

/**
 *
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个遍历100以内的奇数
 *
 * @author taia
 * @creat 2021-10-12-10:48
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        ThDemo1 thDemo1 = new ThDemo1();
//        ThDemo2 thDemo2 = new ThDemo2();
//
//        thDemo1.start();
//        thDemo2.start();


        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                //遍历100以内的偶数
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("demo 1 i = " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {

                    //遍历100以内的奇数
                    for (int i = 0; i < 100; i++) {
                        if (i % 2 != 0) {
                            System.out.println("demo 2 i = " + i);
                        }
                    }
                }

        }.start();


    }

}

class ThDemo1 extends Thread{
    @Override
    public void run() {
        //遍历100以内的偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("demo 1 i = " + i);
            }
        }

    }
}

class ThDemo2 extends Thread{
    @Override
    public void run() {
        //遍历100以内的奇数
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("demo 2 i = " + i);
            }
        }
    }
}


