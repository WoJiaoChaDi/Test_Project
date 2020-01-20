package com.xd;

import org.junit.Test;

import java.io.IOException;

public class TestRuntime {

    @Test
    public void test1() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        //执行cmd命令
        // /c 执行完后关闭命令窗口
        // /k 执行完后不关闭命令窗口
        // cd.>d:1.txt   在d盘下新建1.txt文件
        runtime.exec("cmd /c cd.>d:1.txt");
        // calc 打开计算器
        runtime.exec("cmd /c calc");
        // 用wmic命令杀死calc进程
        runtime.exec("cmd /c start wmic process where name='calc' call terminate");
    }
}
