package com.taiacloud.java1.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 1.JDBC:sun公司提供的一套API（java.sql,javax.sql）,
 *  使用这套API可以实现对数据的连接和操作（DML、DDL、DCL）
 * 2.如下代码来测试：获取mysql数据库的连接
 *  准备工作：
 *      mysql服务开启
 *      连接的基本条件：ip地址、端口号、用户名、密码
 *      导入mysql的驱动（即为jdbc中相关接口的实现类的集合）
 *
 * 3.网络编程中的url：代表着互联网中的某一资源的地址。
 *  协议：//ip地址：端口号/目标资源？参数列表
 *
 *
 *
 *
 */
public class ConnectionTest {
    /*
    * 获取数据库的连接方式一
    * */
    @Test
    public void test1() throws SQLException {
        //提供mysql中Driver接口的实现类
        Driver driver = new com.mysql.jdbc.Driver();
        //注册驱动
        DriverManager.registerDriver(driver);


        String url = "jdbc:mysql://localhost:3306/temp";//test表示数据库名
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /*
     * 获取数据库的连接方式二（使用反射实现Driver对象的实例化）
     *
     * 面向接口编程：使程序具备更好的移植性
     * */
    @Test
    public void test2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //提供mysql中Driver接口的实现类的对象
        String className = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(className);
        Driver driver = (Driver)clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);


        String url = "jdbc:mysql://localhost:3306/temp";//test表示数据库名
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /*
     * 获取数据库的连接方式三：省略注册的过程
     *
     * 面向接口编程：使程序具备更好的移植性
     * */
    @Test
    public void test3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1.获取连接的四个基本信息
        //在mysql中，以下两行也可省略
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/temp";//test表示数据库名
        String user = "root";
        String password = "root";
        //注册驱动
//        DriverManager.registerDriver(driver);

        /*
        * 之所以不在代码中显式使用DriverManager注册功能，是因为在mysql的Driver类的源码中发现
        * */
        //2.加载驱动
        Class.forName(className);
        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /*
    *  获取数据库的连接方式四：将数据库连接的基本信息声明在配置文件中
    *
    *  使用配置文件的好处？
    *   1.实现了数据和代码的分离，解耦。
    *   2.编写好的java程序在部署到java服务器上时，需要打包。如果java代码修改过，就需要重新打包。
    *   使用配置文件的方式，如果配置信息修改，并没有导致代码的修改，所以并不需要重新打包。
    * */
    @Test
    public void test4() throws IOException, ClassNotFoundException, SQLException {
        //1.读取配置文件中的4个基本信息
        Properties pros = new Properties();
        //加载资源的路径默认为：src下
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        pros.load(is);

        String className = pros.getProperty("className");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        //2.加载驱动
        Class.forName(className);
        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }



}
