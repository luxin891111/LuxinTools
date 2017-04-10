
package com.luxin.common.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 使用输出流进行编程的步骤：
 * 1、建立输出流
 * 2、向流中写入数据
 * 3、关闭输出流
 * 
 */
public class FileWriterUtils {

    /*
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "E:/test/file.txt";
        String content = "new append!";
        // 按方法A追加文件
        FileWriterUtils.appendMethodA(fileName, content);
        FileWriterUtils.appendMethodA(fileName, "append end. \n");
        // 显示文件内容
        FileReadUtils.readFileByLines(fileName);
        // 按方法B追加文件
        FileWriterUtils.appendMethodB(fileName, content);
        FileWriterUtils.appendMethodB(fileName, "append end. \n");
        // 显示文件内容
        FileReadUtils.readFileByLines(fileName);
    }
}
