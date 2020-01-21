package com.xd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static List<String> list = Arrays.asList("eee", "bbb", "ddd", "ccc", "aaa", "aaa", "ccc", "ddd" );
    public static List<Integer> list1 = Arrays.asList(9, 5, 2, 1, 1, 3, 4, 5, 9, 7, 7, 5, 8 ,3);

    public static void main(String[] args) {
        //stream流不能重复使用,每次需要进行流操作，就需要重新获取一次流
        Stream<String> stream = list.stream();
        stream.forEach((x) -> System.out.println(x));

        //筛选与切片
        //过滤
        list.stream().filter((x) -> x.indexOf("c") > -1)
                .forEach((x) -> System.out.println(x));
        System.out.println("======");

        //去重(对于自己的对象，需要重写equals和hashCode方法
        list.stream().distinct()
                .forEach((x) -> System.out.println(x));
        System.out.println("======");

        //截取
        list.stream().limit(3)
                .forEach((x) -> System.out.println(x));
        System.out.println("======");

        //跳过元素
        list.stream().skip(4)
                .forEach((x) -> System.out.println(x));
        System.out.println("======");

        //映射方法
        list.stream().map((t) -> t.toUpperCase())
                .forEach((x) -> System.out.println(x));
        //上面等价于
        list.stream().map((t) -> {
            return t.toUpperCase();
        }).forEach((x) -> System.out.println(x));
        System.out.println("======");

        //flatMap
        //list.stream().flatMap()
        System.out.println("======");

        //归约(第一个参数，和第二个参数完成运算，然后把结果再当成第一个参数)
        System.out.println("======归约start======");
        Optional<String> redStr = list.stream().reduce((t, u) -> {
            return t + "_" + u;
        });
        System.out.println(redStr.get());
        System.out.println("======归约end======");

        //收集（将stream进行收集，转换回来）
        System.out.println("======收集======");
        List<String> colList = list.stream().filter((x) -> x.indexOf("c") > -1)
                                            .collect(Collectors.toList());
        System.out.println(colList);
        System.out.println("======收集======");

        //排序
        list.stream().sorted()
                .forEach((x) -> System.out.println(x));
        System.out.println("======");
        list1.stream().sorted((t1, t2) -> {
            return t1-t2;
        }).forEach((x) -> System.out.println(x));
        System.out.println("======");

        //匹配与查找
        //流中是否每个元素都匹配
        boolean flag = list.stream().allMatch((x) -> x.indexOf("c")>-1);
        System.out.println(flag);
        //流中任何一个元素匹配
        boolean flag1 = list.stream().anyMatch((x) -> x.indexOf("c")>-1);
        System.out.println(flag1);
        //流中全部都不匹配，返回true
        boolean flag2 = list.stream().noneMatch((x) -> x.indexOf("u")>-1);
        System.out.println(flag2);
        //第一个元素
        Optional<String> str1 = list.stream().findFirst();
        System.out.println(str1.get());
        //任意一个元素(?)
        Optional<String> str2 = list.stream().findAny();
        System.out.println(str2.get());
        //元素总数
        long l = list.stream().count();
        System.out.println(l);
        //最大值
        Optional<Integer> max = list1.stream().max((t1, t2) -> t1-t2);
        System.out.println(max.get());
        //最小值
        Optional<Integer> min = list1.stream().min((t1, t2) -> t1-t2);
        System.out.println(min.get());

        //将字符串数组，提取成字符并且去重(感受map和flatMap区别）
        //map返回的还是Stream<String[]>   flatMap返回的是Stream<String>
        String[] ss = new String[]{"Hello", "World"};
        Stream<String[]> stream1 = Stream.of(ss).map(str -> str.split(""));
        Stream<String> stream2 = stream1.flatMap(str -> Arrays.stream(str)).distinct();
        List<String> s = stream2.collect(Collectors.toList());
        System.out.println(s);


        System.out.println("=======distinct 需要重新对象的 equals 和 hashCode 方法");
        System.out.println("======= 未重写 equals 和 hashCode 方法");
        List list1 = Arrays.asList(new Student1("范闲", 18),
                                    new Student1("范闲", 18),
                                    new Student1("庆帝", 34),
                                    new Student1("陈萌萌", 33));
        list1.stream().distinct().forEach((x) -> System.out.println(x.toString()));

        System.out.println("======= 已重写 equals 和 hashCode 方法");
        List list2 = Arrays.asList(new Student2("范闲", 18),
                                    new Student2("范闲", 18),
                                    new Student2("庆帝", 34),
                                    new Student2("陈萌萌", 33));
        list2.stream().distinct().forEach((x) -> System.out.println(x.toString()));
    }
}

class Student1 {
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return age == student2.age &&
                Objects.equals(name, student2.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
