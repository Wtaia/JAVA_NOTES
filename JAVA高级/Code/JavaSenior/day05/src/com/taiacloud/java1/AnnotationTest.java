package com.taiacloud.java1;

import java.util.Date;

/**
 * 注解的使用：
 * 1.理解Annotation：
 *     1.1 jdk 5.0 新增功能
 *     1.2 Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 *     通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *     代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 *     1.3 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
 *     在JavaEE/Android中注解占据了更重要的角色.
 * 2.Annotation示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *      @Override: 限定重写父类方法, 该注解只能用于方法
 *      @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *      @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照@SuppressWarnings去定义
 *  3.1注解声明为：@interface
 *  3.2内部定义成员，通常使用value表示
 *  3.3可以指定成员的默认值，使用default定义
 *  3.4如果自定义的注解没有成员，表明是一个标识作用
 *
 *
 *  如果注解有成员，那么在使用注解时，需要指明成员的值。
 *  自定义注解必须配上注解的信息处理流程（使用反射）才有意义。
 *  自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4.jdk5.0 提供的四种元注解：元 Annotation 用于修饰其他 Annotation 定义
 *  Retention：指定该 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME。
 *              只有声明为RUNTIME的注解才能通过反射获取。
 *  Target：用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
 *              @Target 也包含一个名为 value 的成员变量。
 *  **********************************出现频率较低**********************************
 *  Documented：用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。
 *              默认情况下，javadoc是不包括注解的。
 *  Inherited：: 被它修饰的 Annotation 将具有继承性。
 *              如果某个类使用了被@Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 *
 * 5.通过反射获取注解信息 -----到反射内容再系统讲解
 *
 * 6.jdk 8 注解新特性
 *  6.1可重复注解：
 *      6.1.1.再MyAnnotation上声明@Repeatable，成员值为MyAnnotations。class
 *      6.1.2.MyAnnotation的Target和Retention和MyAnnotations和Inherited保持相同
 *  6.2类型注解：JDK1.8之后，关于元注解@Target的参数类型ElementType枚举值多了两个：TYPE_PARAMETER,TYPE_USE。
 *          在Java 8之前，注解只能是在声明的地方所使用，Java8开始，注解可以应用在任何地方。
 *       ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *       ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 * @author taia
 * @creat 2021-10-19-17:11
 */
public class AnnotationTest {
    public static void main(String[] args) {

        Person p = new Student();
        p.walk();

        //@Deprecated:
        Date date = new Date(2021,10,11);
        System.out.println(date);

        //@SuppressWarnings:
        @SuppressWarnings("unused")
        int num = 10;

    }
}

//@MyAnnotation(value = "hi")
//@MyAnnotation("hi")
@MyAnnotation
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("walk");
    }

    public void eat(){
        System.out.println("eat");
    }
}

interface Info{
    void show();
}

//@Override:
class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("student walk");
    }


    @Override
    public void show() {
        System.out.println("show");
    }
}
