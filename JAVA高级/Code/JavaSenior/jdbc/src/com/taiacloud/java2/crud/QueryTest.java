package com.taiacloud.java2.crud;

import com.taiacloud.java1.util.JDBCUtils;
import com.taiacloud.java2.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试数据包的查询操作
 */
public class QueryTest {
    /**
     * BeanHandler:对应的查询表中的一条记录，以对象的方式返回
     */
    @Test
    public void test1() {
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select id,last_name,email,hire_date,salary from emp7 where id = ?";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(connection, sql, handler, 3);//rsh:ResultSetHandle,第三个参数

            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }

    }


    /**
     * BeanListHandler:对应的查询表中的多条记录，以对象构成的集合的方式返回
     */
    @Test
    public void test2() {
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select id,last_name,email,hire_date,salary from emp7 where id > ?";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> list = runner.query(connection, sql, handler, 1);//rsh:ResultSetHandle,第三个参数

//            System.out.println(list);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }


    }

    /**
     * mapHandler:对应的查询表中的一条记录，以map对象的方式返回，
     * map中key为表中的字段名，map中value为表中一条数据的数据值。
     */
    @Test
    public void test3() {
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select id,last_name,email,hire_date,salary from emp7 where id = ?";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            MapHandler handler = new MapHandler();
            //ResultSetHandler<Map<String,Object>> handler = new MapHandler();
            Map<String, Object> map = runner.query(connection, sql, handler, 3);//rsh:ResultSetHandle,第三个参数

            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }

    }

    /**
     * mapListHandler:对应的查询表中的多条记录，以map对象构成的list方式返回，
     * map中key为表中的字段名，map中value为表中一条数据的数据值。
     */
    @Test
    public void test4() {
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select id,last_name,email,hire_date,salary from emp7 where id > ?";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            MapListHandler handler = new MapListHandler();
            //ResultSetHandler<list<Map<String,Object>>> handler = new MapListHandler();
            List<Map<String, Object>> mapList = runner.query(connection, sql, handler, 1);//rsh:ResultSetHandle,第三个参数

//            System.out.println(mapList);
            mapList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }

    }

    /**
     * ScalarHandler:用于查询表中的特殊值。
     * 比如：count(*)\max(xxx)
     */
    @Test
    public void test5(){
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select count(*) from emp7";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            ScalarHandler handler = new ScalarHandler<>();
            long count = (long)runner.query(connection, sql, handler);

            System.out.println("查询的表中一共有：" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }
    }

    @Test
    public void test6(){
        Connection connection = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一条带占位符的查询语句sql
            String sql = "select max(hire_date) from emp7";
            //3.创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();
            //4.通过QueryRunner的实例，调用其query()方法
            ScalarHandler handler = new ScalarHandler<>();
            Date hire_date = (Date) runner.query(connection, sql, handler);

            System.out.println("查询的表中最大的雇佣日期：" + hire_date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(connection);
        }
    }


}