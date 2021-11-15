package com.taiacloud.exer;

/**
 * @author taia
 * @creat 2021-10-15-19:29
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good 不可变性
        System.out.println(ex.ch);//best
    }
}
