package com.xd;

import java.util.*;
import java.util.stream.Collectors;

public class TestLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(444);
        list.add(111);
        list.add(555);
        list.add(333);
        list.add(222);
        List<String> strList = new ArrayList<>();
        strList.add("112");
        strList.add("111");
        strList.add("113");
        strList.add("114");
        strList.add("115");
        strList.add("212");
        strList.add("211");
        strList.add("213");
        strList.add("214");
        strList.add("215");

        //遍历
        list.forEach(str -> System.out.println(str));
        System.out.println("==========");
        //方法引用
        list.forEach(System.out::println);
        System.out.println("==========");

        //过滤
        list.stream().filter(e -> e>111)
                .forEach(e -> System.out.println(e));
        System.out.println("==========");

        //取指定个数
        list.stream().limit(3).filter(e -> e>222)
                .forEach(e -> System.out.println(e));
        System.out.println("==========");

        list.stream().filter(e -> e>222).limit(3)
                .forEach(e -> System.out.println(e));

        //排序
        list.stream().sorted((x, y) -> x-y)
                .forEach(e -> System.out.println(e));
        System.out.println("==========");

        //最大值、最小值
        Integer max = list.stream().max((x, y) -> x-y).get();
        Integer min = list.stream().min((x, y) -> x-y).get();
        System.out.println(max);
        System.out.println(min);

        //进行函数操作后返回
        System.out.println("==========");
        list.stream().map(e -> e+0.001)
                .forEach(e -> System.out.println(e));
        System.out.println("==========");


        //递归的执行函数
        //reduce第一个参数的值是  上次函数的返回值
        //第二个参数的值是 这次参数的操作值
        //第一次运行时，第一个参数是stream的第一个值，第二个参数是stream的第二个值
        Integer reduce = list.stream().reduce((x, y) -> x + y).get();
        //带初始值的计算
        Integer reduce2 = list.stream().reduce( 5, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println(reduce2);
        System.out.println("==========");

        //将stream转换回集合对象
        List newList = list.stream().filter(e -> e>222).collect(Collectors.toList());
        newList.forEach(e -> System.out.print(e + "  "));
        System.out.println();
        String newStr = strList.stream().filter(e -> e.contains("2")).collect(Collectors.joining(","));
        System.out.println(newStr);
        System.out.println("==========");

        //summaryStatistics计算结果的各种值
        IntSummaryStatistics statistics = list.stream().mapToInt(e -> e).summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
        System.out.println("==========");


        System.out.println();

        //lambda表达式，实现Comparator接口
        Comparator<String> com = (x, y) -> x.compareTo(y);
        TreeSet<String> ts = new TreeSet<>(com);
        ts.add("g");
        ts.add("a");
        ts.add("h");
        ts.add("b");
        ts.add("e");
        ts.add("d");
        ts.add("c");
        ts.forEach(str -> System.out.println(str));

        //lambda表达式，实现runnable线程接口（无参数）
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("=" +i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
