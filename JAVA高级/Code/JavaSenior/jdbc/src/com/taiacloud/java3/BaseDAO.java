package com.taiacloud.java3;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO:database access object  数据库访问对象
 */
public abstract class BaseDAO {
    private QueryRunner runner = new QueryRunner();

    //通用的增删改操作
    public int update(Connection connection,String sql,Object ... objs) throws SQLException {

        int count = runner.update(connection, sql, objs);
        return count;
    }

    //查询操作：查询表中的一条记录
    public <T> T getInstance(Connection connection,String sql,Class<T> clazz,Object ... objs) throws SQLException {
        BeanHandler<T> handler = new BeanHandler<T>(clazz);
        T instance = runner.query(connection, sql, handler, objs);
        return instance;
    }

    //查询操作：查询表中的多条记录
    public <T> List<T> getForList(Connection connection,String sql,Class<T> clazz,Object ... objs) throws SQLException {
        BeanListHandler<T> handler = new BeanListHandler<T>(clazz);
        List<T> list = runner.query(connection, sql, handler, objs);
        return list;
    }
    //查询操作：查询表中的特殊值
    public <T> T getValue(Connection connection,String sql,Object ... objs) throws SQLException {

        ScalarHandler<Object> handler = new ScalarHandler<>();
        Object value = runner.query(connection, sql, handler, objs);

        return (T) value;
    }


}
