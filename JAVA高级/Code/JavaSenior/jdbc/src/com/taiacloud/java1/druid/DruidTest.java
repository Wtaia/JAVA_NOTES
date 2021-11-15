package com.taiacloud.java1.druid;

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
 *  1.更方便的获取连接对象，效率高
 *  2.资源可以更好的复用
 *  3，便于进行必要的管理
 *
 * 二、数据库连接池技术
 *  1.DBCP：速度快，有bug，不在提供支持
 *  2.C3P0：连接稳定，速度相对较慢
 *  3.Druid：稳定、速度快
 *
 *
 * 三、DataSource 通常被称为数据源，它包含连接池和连接池管理两个部分，习惯上也经常把 DataSource 称为连接池。
 */
public class DruidTest {
    /**
     * 方式一：使用Druid数据库连接池获取数据库的连接
     * @throws SQLException
     */

    @Test
    public void test1() throws SQLException {
        //DataSource是一个数据源，一般看做数据库连接池
        DruidDataSource source = new DruidDataSource();

        //设置4个基本信息
        source.setUsername("root");
        source.setPassword("root");
        source.setUrl("jdbc:mysql://localhost:3306/temp");
        source.setDriverClassName("com.mysql.jdbc.Driver");

        //还可以设置其他信息
        source.setMaxActive(10);//设置连接池最大的连接数量
        source.setInitialSize(10);//初始化时提供的连接数

        //获取连接池的一个数据库连接
        Connection connection = source.getConnection();

        System.out.println(connection);
    }


    /**
     * 方式二：将数据库连接的基本信息声明在配置文件中
     */

    @Test
    public void test2() throws Exception {

        //提供properties，并加载指定配置文件的流
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);

        //通过DruidDataSourceFactory创建一个数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);

        //通过数据源获取连接
        System.out.println(dataSource.getConnection());

    }

}
