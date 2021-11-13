package com.atguigu.java1.test;

import com.atguigu.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author shkstart
 * @create 11:43
 */
public class JDBCUtilsTest {

    @Test
    public void test1() throws Exception {

        Connection connection = JDBCUtils.getConnection();


        System.out.println(connection);
    }
}
