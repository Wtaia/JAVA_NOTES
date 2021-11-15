package com.taiacloud.java3;

import com.taiacloud.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class CustomerDaoImplTest {

    @Test
    public void testGetAll(){
        Connection connection = null;
        try {
            CustomerDAOImpl impl = new CustomerDAOImpl();
            connection = JDBCUtils.getConnection();
            List<Customer> list = impl.getAll(connection);

            for (Customer customer : list) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }


    }
}
