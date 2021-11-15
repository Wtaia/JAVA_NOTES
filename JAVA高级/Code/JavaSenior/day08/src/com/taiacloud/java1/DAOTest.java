package com.taiacloud.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author taia
 * @creat 2021-10-23-18:21
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

    }
}
