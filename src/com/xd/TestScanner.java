package com.xd;

import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args) {

        //获取控制台输入的Scanner
        Scanner scanner = new Scanner(System.in);
        // scanner.next() 等待控制台输入，按下回车读取控制台的输入 直到空格，并且光标定位在本行
        // 如果没有读取完，下一个scanner.next()会继续读取上次scanner中的内容
        // 如果读取完了，则控制台会进入等待，等待新的输入
        System.out.println(scanner.next());
        System.out.println(scanner.next());

        //等待输入，按下回车会 读取控制台的输入，直到该行最后，并且光标定位到下一行
        System.out.println(scanner.nextLine());

        //等待Int类型的输入，
        System.out.println(scanner.nextInt());

    }
}
