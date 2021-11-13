package com.atguigu.java4;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1.数据库事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * <p>
 * 2. 事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现
 * 了故障，都不能改变这种执行方式。当在一个事务中执行多个操作时，要么
 * 所有的事务都被提交(commit)，那么这些修改就永久地保存下来；要么数据库
 * 管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 *
 * @author shkstart
 * @create 17:01
 */
public class TransactionTest {

    /*
     * 场景： AA 给 BB 转账 100
     *
     * 操作1：update user_table set balance = balance - 100 where user = 'AA'
     *
     * 操作2：update user_table set balance = balance + 100 where user = 'BB'
     * */

    @Test
    public void test() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            QueryRunner runner = new QueryRunner();

            //1.设置数据不能自动提交
            connection.setAutoCommit(false);

            //操作1：
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            runner.update(connection, sql1, "AA");
            System.out.println("AA转出成功");

            //模拟异常的出现
            System.out.println( 10 / 0);

            //操作2：
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            runner.update(connection, sql2, "BB");
            System.out.println("BB转入成功");

            //2. 提交数据
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();

            //3.回滚数据
            try {
                if(connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            JDBCUtils.close(connection);
        }


    }


}
