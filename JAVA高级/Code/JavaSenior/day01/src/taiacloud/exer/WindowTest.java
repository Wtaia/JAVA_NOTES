package taiacloud.exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 *  存在线程安全问题待解决
 *
 * @author taia
 * @creat 2021-10-12-17:23
 */
public class WindowTest {


    public static void main(String[] args) {

        Windows windows1 = new Windows();
        Windows windows2 = new Windows();
        Windows windows3 = new Windows();

        windows1.setName("窗口一：");
        windows2.setName("窗口二：");
        windows3.setName("窗口三：");

        windows1.start();
        windows2.start();
        windows3.start();

    }

}


class Windows extends Thread{
    private static int num = 100;

    @Override
    public void run() {
        while (true){
            if(num > 0){
                System.out.println(Thread.currentThread().getName() + "卖票一张,票号为：" + num );
                num--;
            }else{
                break;
            }
        }
    }
}
