package com.taiacloud.java2;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 *  1.对于文本文件（.txt\.java\.c\.cpp...），使用字符流处理；
 *  2.对于非文本文件(.jpg\.mp3\.mp4\.avi\.ppt\.doc...)，使用字节流处理；
 *
 * @author taia
 * @creat 2021-10-25-19:29
 */
public class FileInputOutputStreamTest {
    /**
     * 使用FileInputStream处理文本文件，是可能出现乱码的。
     * 字节流可以用来处理英文字符，和字符流相同，因为在 utf-8 编码中，一个英文字母就占用一个字节
     * 中文以及其他字符不可以这么操作，文本文件还是用字符流处理
     */
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭流
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 实现对图片的复制操作
     * @throws IOException
     */
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("WeChat_pic.jpg");
            File destFile = new File("WeChat_pic_copy.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //使用字节流进行指定路径下文件的复制
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制过程
//            byte[] buffer = new byte[5];//57940ms
            byte[] buffer = new byte[1024];//510ms
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\TAIA\\Desktop\\尚硅谷Java零基础入门教程（含百道Java真题，2万多行Java代码实战）\\652.650.尚硅谷_反射-获取运行时类的方法的内部结构(Av48144058,P652).mp4";
        String destPath = "C:\\Users\\TAIA\\Desktop\\1.mp4";

        copyFile(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start) + "ms");
    }



}
