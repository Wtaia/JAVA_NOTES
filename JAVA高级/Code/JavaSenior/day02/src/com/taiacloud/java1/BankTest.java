package com.taiacloud.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写成线程安全的
 *
 * @author taia
 * @creat 2021-10-13-19:28
 */
public class BankTest {
}

class Bank {

    private Bank() {

    }

    private static Bank instance = null;

    //方式一 同步方法
    //public static synchronized Bank getInstance(){
    public static Bank getInstance() {
        //方式二：同步代码块--效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式三：同步代码块--效率高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
