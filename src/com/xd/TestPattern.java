package com.xd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {

        String content = "I am noob from runoob.com.";
        //String patt = "/.?noob.?/";
        String patt = ".?noob.?";
        boolean bl = Pattern.matches(patt, content);
        System.out.println("是否匹配到：" + bl);

        Pattern pattern = Pattern.compile(patt);
        System.out.println(pattern.pattern());
        Matcher matcher = pattern.matcher(content);
        System.out.println("=======");
        System.out.println("matches是否匹配到：" + matcher.matches());//需要对整个字符串进行匹配，只有整个字符串匹配了才返回true
        System.out.println("lookingAt是否匹配到：" + matcher.lookingAt());//对前面的字符串进行匹配，只有匹配到的字符串在最前面才返回true
        System.out.println("find是否匹配到：" + matcher.find());//对字符串进行匹配，匹配的字符串可以在任意位置，返回true，并且使用掉该次匹配

        System.out.println("=======");
        while (matcher.find()){
            //由于上面的matcher.find()使用掉了一次，所以循环中只有第二次的匹配
            System.out.println(matcher.start());//字符串第一个字符所在的位置
            System.out.println(matcher.end());//字符串最后一个字符所在的位置
            System.out.println(matcher.group());//返回匹配的字符串
        }
        System.out.println("=======");
    }
}
