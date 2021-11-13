package com.atguigu.java1.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 一、使用数据库连接池技术的好处？
 * 1. 更方便的获取连接对象，效率高
 * 2. 资源可以更好的重复利用
 * 3. 便于进行必要的管理
 *
 * 二、有哪些数据库连接池技术呢？ DBCP : 速度快，不稳定； C3P0:稳定、速度慢 ； Druid:兼具二者的优点
 *
 * 三、 DataSource 通常被称为数据源，它包含连接池和连接池管理两个部分，习惯上也经常把 DataSource 称为连接池
 *
 * @author shkstart
 * @create 11:14
 */
public class DruidTest {

    /*
    * 方式一：使用Druid数据库连接池获取数据库的连接
    *
    * */
    @Test
    public void test1() throws SQLException {

        //看做是获取了一个数据库连接池
        DruidDataSource source = new DruidDataSource();

        //设置4个基本信息
        source.setUsername("root");
        source.setPassword("abc123");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClassName("com.mysql.jdbc.Driver");

        //还可以设置其他信息
        source.setMaxActive(10);
        source.setInitialSize(5);

        //获取连接池中的一个数据库连接
        Connection connection = source.getConnection();

        System.out.println(connection);
    }

    /*
    * 方式二：将数据库连接的基本信息声明在配置文件中
    *
    * */
    @Test
    public void test2() throws Exception {
        //提供Properties，并加载指定配置文件的流
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);

        //通过DruidDataSourceFactory创建一个数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);

        //通过数据源获取连接
        System.out.println(dataSource.getConnection());

    }
}
