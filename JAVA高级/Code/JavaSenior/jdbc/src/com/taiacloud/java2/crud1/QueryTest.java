package com.taiacloud.java2.crud1;

import com.taiacloud.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

/**
 * 如果表中的字段名与类中的属性名不一致，为了查询操作的准确性我们需要编写sql时，
 * 使用类的属性名作为select后字段的别名出现。
 */
public class QueryTest {
    /**
     * 查询order表中的一条记录，返回Order类的一个对象
     */
    @Test
    public void test1() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "select id orderId,last_name orderName,hire_date orderDate from emp7 where id = ?";//若emp7转化为order则会在sql中报关键字错误
                                                                                                        //使用`order`可以解决

        BeanHandler<emp7> handler = new BeanHandler<emp7>(emp7.class);

        QueryRunner runner = new QueryRunner();
        emp7 query = runner.query(connection, sql, handler, 3);

        System.out.println(query);




    }
}
