package com.taiacloud.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author taia
 * @creat 2021-10-22-20:53
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件；key和value都是String类型；
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println(name + " " + password);

    }
}
