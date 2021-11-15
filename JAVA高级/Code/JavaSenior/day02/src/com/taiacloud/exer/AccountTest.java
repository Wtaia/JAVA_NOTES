package com.taiacloud.exer;

/**
 *
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * 分析：
 *  1.是否是多线程的问题？是，两个储户线程
 *  2.是否有共享数据？ 有，账户
 *  3.是否有线程安全问题？ 有
 *  4.如何解决线程安全问题？ 同步机制
 *
 *
 * @author taia
 * @creat 2021-10-13-20:52
 */


class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    //存钱方法
    public synchronized void depoist(double amt){

        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread{
    private Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.depoist(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
