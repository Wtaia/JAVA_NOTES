package com.taiacloud.java2.crud;

import com.taiacloud.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

/**
 * 测试向数据表中添加、删除、修改数据
 */
public class UpdateTest {
    //像数据中添加一条记录
    @Test
    public void test1(){
        Connection connection = null;
        try {
            //1.先获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一个添加操作的sql
            String sql = "insert into emp7(last_name,email,hire_date,salary)values('王五','123@123.com',now(),1000)";
            //3.使用提供好的QueryRunner，调用update（）方法，实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql);
            System.out.println("添加了" + count + "数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //4.资源的关系
            JDBCUtils.close(connection);
        }

    }

    /**
     * 使用带占位符的SQL（推荐）
     */
    @Test
    public void test2(){
        Connection connection = null;
        try {
            //1.先获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一个包含占位符的sql
            String sql = "insert into emp7(last_name,email,hire_date,salary)values(?,?,?,?)";
            //3.使用提供好的QueryRunner，调用update（）方法，实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql,"666","678@123.com",new Date(234234564356L),1000);
            System.out.println("添加了" + count + "数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //4.资源的关系
            JDBCUtils.close(connection);
        }

    }

    /**
     * 删除记录操作
     */
    @Test
    public void test3(){
        Connection connection = null;
        try {
            //1.先获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一个包含占位符的sql
            String sql = "delete from emp7 where id < ?";
            //3.使用提供好的QueryRunner，调用update（）方法，实现数据的删除
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql,2);
            System.out.println("删除了" + count + "数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //4.资源的关系
            JDBCUtils.close(connection);
        }
    }

    /**
     * 修改数据操作
     */
    @Test
    public void test4(){
        Connection connection = null;
        try {
            //1.先获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.提供一个包含占位符的sql
            String sql = "update emp7 set hire_date = now() where id = ?";
            //3.使用提供好的QueryRunner，调用update（）方法，实现数据的修改
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql,5);
            System.out.println("修改了" + count + "数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //4.资源的关系
            JDBCUtils.close(connection);
        }
    }
}
