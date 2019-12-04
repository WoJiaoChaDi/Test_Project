package com.xd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class TestFuncInterface {

    //Java8 内置四大核心函数式接口
    public static void main(String[] args) {

        //接收一个int参数，返回一个R类型
        IntFunction<String> intFunction = (t) -> {
            return "返回类型" + t*t;
        };
        String intFunc = intFunction.apply(2);
        System.out.println(intFunc);

        //接收一个long参数，返回一个R类型
        //LongFunction<String>
        //接收一个double参数，返回一个R类型
        //DoubleFunction<String>


        //接收一个参数，返回int类型
        ToIntFunction<Integer> toIntFunction = (x) -> {
            return x*x;
        };
        //接收一个参数，返回long类型
        //ToLongBiFunction<T>
        //接收一个参数，返回double类型
        //ToDoubleBiFunction<T>


        //接收两个参数，没有返回值
        BiConsumer<String, Integer> biConsumer = (t, u) -> {
            for (int i = 0; i < u; i++) {
                t = t + i;
            }
            System.out.println(t);
            System.out.println(u);
        };
        biConsumer.accept("参数", 8);


        //接收两个相同类型的参数，返回同类型的参数
        BinaryOperator<String> binaryOperator = (t, u) -> {
            return t + u;
        };
        String binOperStr = binaryOperator.apply("我和", "你");
        System.out.println(binOperStr);


        //接收一个参数，返回同类型的参数
        UnaryOperator<String> unaryOperator = (t) -> {
            return t+t;
        };
        String unaryStr = unaryOperator.apply("一次");
        System.out.println(unaryStr);


        //接收两个参数，有返回值
        BiFunction<String, Integer, String> biFunction = (t, u) -> {
            for (int i = 0; i < u; i++) {
                t = t + i;
            }
            return t;
        };
        String biStr = biFunction.apply("abc", 5);
        System.out.println(biStr);


        //断言型接口(接收一个参数，返回boolean类型)
        Predicate<String> predicate = (x) -> {
            return x.indexOf("x")>-1;
        };
        List<String> list1 = Arrays.asList("1x111a", "11y11b", "111d1c", "1111xd", "1111ez");
        List<String> newList1 = predicateFuc(list1, predicate);
        System.out.println(newList1);


        //函数型接口（接收一个参数、有返回值）
        Function<String, String > func = (x) -> {
            return x.trim().replace(" ", "").replace("\t", "");
        };
        String str = func.apply("  这里  空格  什么的 \t\t\t 有点 \t多！  ！！");
        System.out.println(str);


        //供给型接口（无需参数、有返回值）
        Supplier<Integer> supplier = () -> {
            int i = (int)(Math.random()*100);
            return i;
        };
        List<Integer> list = supplierFuc(10, supplier);
        System.out.println(list);


        //消费型接口（接收一个参数，无返回值）
        //只用于执行内容
        Consumer<Integer> consumer = (x) -> {
            int a = x +2;
            System.out.println(a);
            System.out.println(a + "_");
        };
        consumer.accept(100);

    }

    //断言型接口(接收一个参数，返回boolean类型)
    public static List<String> predicateFuc(List<String> list, Predicate<String> predicate){
        List<String> newList = new ArrayList();
        for (String s : list) {
            if(predicate.test(s)){
                newList.add(s);
            }
        }
        return newList;
    }

    //供给型接口（无需参数）
    //有返回值
    public static List<Integer> supplierFuc(int num, Supplier<Integer> supplier){
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

}
