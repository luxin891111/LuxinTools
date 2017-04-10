
package com.luxin.common.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void main(String[] args) {
        File file = new File("e:\\test");

        // 显示所有文件夹和文件调用
        // FileUtils.printAllFile(file);
        // 删除所有文件夹和文件调用
        // FileUtils.deleteAllFile(file);

        // 文件的基本方法调用
        // fileUtils.fileCommon();
    }

    // 文件的基本方法演示
    public static void fileCommon() {
        // 创建File对象
        File file1 = new File("e:\\test\\file.txt");
        File file2 = new File("e:\\test\\test1");
        File file3 = new File("e:\\test\\test1\\file1.txt");

        // 创建文件
        try {
            boolean flag = file1.createNewFile();
            System.out.println("创建文件: " + flag);
        } catch(IOException e) {
            e.printStackTrace();
        }
        // 创建文件夹
        boolean flag1 = file2.mkdirs();
        System.out.println("创建文件夹: " + flag1);
        boolean flag2;
        try {
            flag2 = file3.createNewFile();
            System.out.println("创建文件file3: " + flag2);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // 判断文件是否存在
        System.out.println("判断文件是否存在: " + file1.exists());
        // 获得文件的绝对路径
        System.out.println("获得文件的绝对路径: " + file1.getAbsolutePath());
        // 获得文件名
        System.out.println("获得文件名: " + file1.getName());
        // 获得父路径
        System.out.println("获得父路径: " + file1.getParent());
        // 判断是否是目录
        System.out.println("判断是否是目录: " + file1.isDirectory());
        // 判断是否是文件
        System.out.println("判断是否是文件: " + file1.isFile());
        // 获得文件长度
        System.out.println("获得文件长度: " + file1.length());

        // 获得当前文件夹下所有文件和文件夹名称
        String[] fileNames = file2.list();
        for(String name : fileNames) {
            System.out.println("获得当前文件夹下所有文件和文件夹名称: " + name);
        }

        // 获得文件对象
        File[] fileObj = file2.listFiles();
        for(File f : fileObj) {
            System.out.println("获得文件对象: " + f);
        }

        // 修改文件名
        File file4 = new File("e:\\test\\a.txt");
        Boolean flag3 = file1.renameTo(file4);
        System.out.println("修改文件名: " + flag3);
    }

    // 打印file路径下所有的文件和文件夹
    public static void printAllFile(File file) {
        // 打印当前文件名
        System.out.println("当前文件名: " + file.getName());
        // file如果是文件夹递归调用
        if(file.isDirectory()) {
            // 获得该文件夹下的所有子文件和子文件夹
            File[] files = file.listFiles();
            for(File f : files) {
                printAllFile(f);
            }
        }
    }

    // 删除对象file下的所有文件和文件夹
    public static void deleteAllFile(File file) {
        // 文件直接删除
        if(file.isFile()) {
            file.delete();
        } else {// 文件夹
                // 获得当前文件夹下的所有子文件和子文件夹
            File[] files = file.listFiles();
            // 递归调用
            for(File f : files) {
                deleteAllFile(f);
            }
            // 删除当前文件夹
            file.delete();
        }
    }

}
