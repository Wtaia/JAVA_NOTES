package com.atguigu.java2.crud1;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

/**
 *
 * 如果表中的字段名与类中的属性名不一致，为了查询操作结果的准确性，我们需要编写sql时，使用类的属性名
 * 作为select 后字段的别名出现。
 *
 * @author shkstart
 * @create 15:47
 */
public class QueryTest {

    /*
    * 查询order表中的一条记录，返回Order类的一个对象
    *
    * */
    @Test
    public void test1() throws Exception {

        Connection connection = JDBCUtils.getConnection();

        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id = ?";

        BeanHandler<Order> handler = new BeanHandler<>(Order.class);

        QueryRunner runner = new QueryRunner();


        Order order = runner.query(connection, sql, handler, 1);

        System.out.println(order);

    }

}
