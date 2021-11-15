package com.taiacloud.java2;

import com.taiacloud.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest {

    /**
     * 运行时类的属性声明为public，不理想
     */
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性:要求运行时类的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        //设置当前属性的值
        //set():参数一：指明哪个对象的属性   参数二：将此属性值设置为多少
        id.set(p,1001);

        //获取当前属性的值
        //get():参数：指明哪个对象的属性
        int pId = (int) id.get(p);
        System.out.println(pId);

    }

    /**
     * 如何操作运行时类指定的属性 -- 掌握
     * @throws Exception
     */
    @Test
    public void testField1() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.set name属性，get name属性   //实际需求
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }

    /**
     * 如何操作运行时类指定的方法 -- 掌握
     */
    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod():参数一：指定获取的方法名 参数二：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);


        //3.invoke():参数1：方法的调用者   参数2：给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object chn = show.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("*************************");

        //private static void showDesc()
        //调用静态方法

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke（）返回null
        Object o = showDesc.invoke(Person.class);
//        Object o1 = showDesc.invoke(clazz);
        System.out.println(o);

    }

    /**
     * 如何操作运行时类指定的构造器
     */
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;

        // private Person(String name)
        //1.获取指定的构造器
        //getDeclaredConstructor(): 参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person person = (Person) constructor.newInstance("jjj");
        System.out.println(person);


    }
}
