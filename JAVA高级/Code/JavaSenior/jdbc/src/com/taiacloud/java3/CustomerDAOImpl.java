package com.taiacloud.java3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO{

    @Override
    public int addCustomer(Connection connection, Customer cust) throws SQLException {
        String sql = "insert into emp7(last_name,email,hire_date)values(?,?,?))";
        int count = update(connection, sql, cust.getLast_name(), cust.getEmail(), cust.getHire_date());

        return count;
    }

    @Override
    public int deleteById(Connection connection, int id) throws SQLException {

        String sql = "delete from emp7 where id = ?";
        int count = update(connection, sql, id);
        return count;
    }

    @Override
    public int updateCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "update emp7 set last_name = ?,email = ?,hire_date = ? where id = ?";
        int count = update(connection, sql, customer, customer.getLast_name(), customer.getEmail(), customer.getHire_date(), customer.getId());
        return count;
    }

    @Override
    public Customer getCustomer(Connection connection, int id) throws SQLException {
        String sql = "select id,last_name,email,hire_date from emp7 where id = ?";
        Customer customer = getInstance(connection, sql, Customer.class, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        String sql = "select id,last_name,email,hire_date from emp7";
        List<Customer> list = getForList(connection, sql, Customer.class);
        return list;
    }

    @Override
    public long getCount(Connection connection) throws SQLException {
        String sql = "select count(*) from emp7";
        long value = getValue(connection, sql);
        return value;
    }

    @Override
    public Date getMaxBirth(Connection connection) throws SQLException {
        String sql = "select max(hire_date) from emp7";
        Date maxBirth = getValue(connection, sql);
        return maxBirth;
    }
}
