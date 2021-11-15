package com.taiacloud.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，并未涉及到修改文件内容的操作，
 * 如果需要操作文件内容，则必须使用IO流。
 * 4.File类的对象常会作为参数传入流的构造器中，指明读取或者写入的“终点”。
 *
 *
 * @author taia
 * @creat 2021-10-23-20:36
 */
public class FileTest {
    /**
     * 1.如何创建File类的实例
     *      File(String filePath)
     *      File(String parentPath,String childPath)
     *      File(File parent,String child)
     * 2.路径：
     *      相对路径：相较于某个路径下，指明的路径。
     *      绝对路径：包含盘符在内的文件或文件目录路径。
     * 3.路径分隔符：
     *      windows：\\
     *      unix：/
     *
     *
     */
    @Test
    public void test1(){
        //构造器一：
        File file1 = new File("hello.txt");//相对于当前module
        File file2 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器二：
        File file3 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\he.txt","Java");
        System.out.println(file3);

        //构造器三：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    /**
     * File类的获取功能
     *  public String getAbsolutePath()：获取绝对路径
     *  public String getPath() ：获取路径
     *  public String getName() ：获取名称
     *  public String getParent()：获取上层文件目录路径。若无，返回null
     *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     *  public long lastModified() ：获取最后一次的修改时间，毫秒值
     *  如下的两个方法适用于文件目录
     *  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     *  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\he.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));


    }

    @Test
    public void test3(){
        File file = new File("D:\\IdeaProjects\\JavaSenior\\day09");

        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }

        System.out.println();
        File[] files = file.listFiles();
        for(File f:files){
            System.out.println(f);
        }
    }

    /**
     * File类的重命名功能
     *  public boolean renameTo(File dest):把文件重命名为指定的文件路径
     *  比如：file1.renameTo(file2)
     *  要想保证是成功的，需要file1在硬盘中是存在的，且file2不能存在
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");//file1必须存在
        File file2 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\hi.txt");//file2不能存在，存在的话重命名失败

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /**
     * File类的判断功能
     *  public boolean isDirectory()：判断是否是文件目录
     *  public boolean isFile() ：判断是否是文件
     *  public boolean exists() ：判断是否存在
     *  public boolean canRead() ：判断是否可读
     *  public boolean canWrite() ：判断是否可写
     *  public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test5(){
        //文件
//        File file1 = new File("he.txt");
        //文件目录
        File file1 = new File("D:\\IdeaProjects\\JavaSenior\\day09");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());


    }

    /**
     * File类的创建功能
     *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
     *  注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
     * File类的删除功能
     *  public boolean delete()：删除文件或者文件夹
     *  注意事项：
     *  Java中的删除不走回收站。要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录。
     */

    @Test
    public void test6() throws IOException {
        //文件的创建
        File file1 = new File("hello.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\IO\\io3");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }
        File file2 = new File("D:\\IdeaProjects\\JavaSenior\\day09\\IO2\\io4");
        boolean mkdir1 = file1.mkdirs();
        if (mkdir1){
            System.out.println("创建成功2");
        }

    }







}
