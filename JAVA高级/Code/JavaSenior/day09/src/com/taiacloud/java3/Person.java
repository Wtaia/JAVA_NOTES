package com.taiacloud.java3;

import java.io.Serializable;

/**
 * Person类需要满足以下要求，方可实例化
 * 1.需要实现接口：Serializable
 * 2.需要当前类提供一个全局常量：serialVersionUID,如果没有这个常量在对象类修改时会报错，出现版本兼容问题。
 * 2.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。（默认，基本数据类型都是可序列化的）
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author taia
 * @creat 2021-10-26-19:38
 */
public class Person implements Serializable {//标识接口，没有抽象方法需要实现
    public static final long serialVersionUID = 475463534532L;

    private String name;
    private int age;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }

    public Account getAcct() {
        return acct;
    }

    public void setAcct(Account acct) {
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



class Account implements Serializable{
    public static final long serialVersionUID = 4754635532L;

    private double balance;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }
}
