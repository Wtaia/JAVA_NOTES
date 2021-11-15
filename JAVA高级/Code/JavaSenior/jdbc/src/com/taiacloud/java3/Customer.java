package com.taiacloud.java3;

import java.sql.Date;

/**
 * ORM(object relational mapping)编程思想：
 *  数据库中的一个表与java中的一个类对应，
 *  表中的一条记录与java类的一个对象对应，
 *  表中的一个字段（列）与类中的一个属性对应。
 */
public class Customer {
    private int id;
    private String last_name;
    private String email;
    private Date hire_date;
    private double salary;

    //二进制文件
//    private Blob photo;


    public Customer() {
    }

    public Customer(int id, String last_name, String email, Date hire_date, double salary) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
        this.hire_date = hire_date;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                '}';
    }
}
