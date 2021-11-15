package com.taiacloud.exer;

import org.junit.Test;

/**
 * @author taia
 * @creat 2021-10-18-14:59
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//null被当成字符串传入

        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);//执行不到
    }
}
