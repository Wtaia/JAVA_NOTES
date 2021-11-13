package com.atguigu.java1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 1.JDBC: sun公司提供的一套api(java.sql,javax.sql)，
 *    使用这套api可以实现对数据的连接和操作(DML、DDL)
 *
 * 2. 如下代码来测试：获取mysql数据库连接
 *  要想获取连接，准备工作：
 *  ① mysql服务开启
 *  ② 连接的基本条件：指名数据库的ip地址、端口号、用户名、密码
 *  ③ 导入mysql的驱动（即为jdbc中相关接口的实现类的集合）
 *
 * 3. 网络编程中的url: 代表着互联网中的某一资源的地址。
 *   http://192.168.21.34:8080/gmall/index.jsp?user=tom
 *   协议    ip地址       端口号  目标资源       参数列表
 *
 *
 * @author shkstart
 * @create 8:52
 */
public class ConnectionTest {

    /*
    获取数据库的连接方式一
     */
    @Test
    public void test1() throws SQLException {

        //提供mysql中Driver接口的实现类
        Driver driver = new com.mysql.jdbc.Driver();

        //注册驱动
        DriverManager.registerDriver(driver);


        String url = "jdbc:mysql://localhost:3306/test";  //test:表示具体的数据库名
        String user = "root";
        String password = "abc123";

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    /*
    获取数据库的连接方式二：使用反射实现Driver的实例化

    面向接口编程，使程序具备更好的移植性
     */
    @Test
    public void test2() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        //提供mysql中Driver接口的实现类的对象
        String className = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(className);
        Driver driver = (Driver) clazz.newInstance();

        //注册驱动
        DriverManager.registerDriver(driver);


        String url = "jdbc:mysql://localhost:3306/test";  //test:表示具体的数据库名
        String user = "root";
        String password = "abc123";

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    /*
    获取数据库的连接方式三：省略注册的过程
     */
    @Test
    public void test3() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        //1. 获取连接的4个基本信息
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";  //test:表示具体的数据库名
        String user = "root";
        String password = "abc123";


        //2. 加载驱动
        Class.forName(className);

        //注册驱动
//        DriverManager.registerDriver(driver);
        /*
        * 之所以不再代码中显式使用DriverManager的注册功能，是因为在msyql的Driver类的源码中发现：
        *  static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        *
        * */
        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    /*
    * 获取数据库的连接方式四：将数据库连接的基本信息声明在配置文件中
    *
    * 使用配置文件方式的好处？
    * 1. 实现了数据和代码的分离，解耦。
    * 2. 编写的java程序在部署到服务器上时，需要打包。如果java代码修改过，就需要重新打包。
    *    使用配置文件的方式，如果配置信息修改，并没有导致代码的修改。所以不需要重写打包。
    * */
    @Test
    public void test4() throws Exception {
        //读取配置文件中的4个基本信息
        Properties pros = new Properties();
        //加载资源的路径默认为：src下
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        pros.load(is);

        String className = pros.getProperty("className");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        //2. 加载驱动
        Class.forName(className);

        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
