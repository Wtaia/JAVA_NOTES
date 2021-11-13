package com.atguigu.java2.bean;

import java.sql.Date;

/**
 *
 * ORM(object relational mapping)编程思想：
 *  数据库中的一个表  与  Java中的一个类对应
 *  表中的一条记录    与  类中一个对象对应
 *  表中的一个列(或字段) 与  类中的一个属性对应
 *
 * @author shkstart
 * @create 14:34
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;
//    private Blob photo;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
