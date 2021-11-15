package com.taiacloud.java3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {

    /**
     * 像数据表中添加一条记录
     * @param connection    数据库的连接
     * @param cust  要添加的数据表中的数据对应的java类对象
     */
    int addCustomer(Connection connection,Customer cust) throws SQLException;

    /**
     * 删除指定id的一条记录
     * @param connection    数据库的连接
     * @param id    要删除的数据对应的id
     */
    int deleteById(Connection connection,int id) throws SQLException;

    /**
     * 修改表中的一条记录
     *
     * Custormer cust = new Customer(10,"张晋","zhang@126.com",new Date(123123L));
     *
     * @param connection    数据库的连接
     * @param customer
     */
    int updateCustomer(Connection connection,Customer customer) throws SQLException;

    /**
     * 根据指定的id，查询表中的一条记录
     * @param connection    数据库的连接
     * @param id    查询的数据对应的id
     * @return  返回要查询的id的对象
     */
    Customer getCustomer(Connection connection,int id) throws SQLException;

    /**
     * 查询表中的所有记录
     * @param connection
     * @return
     */
    List<Customer> getAll(Connection connection) throws SQLException;


    /**
     * 查询表中的条目数
     * @param connection
     * @return
     */
    long getCount(Connection connection) throws SQLException;

    /**
     * 查询最大的生日
     * @param connection
     * @return
     */
    Date getMaxBirth(Connection connection) throws SQLException;

}
