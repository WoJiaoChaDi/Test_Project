package com.xd;

import org.junit.Test;

public class TestReturnThis {

    @Test
    public void test(){
        Student student =  new Student("1", "张三", 18);
        System.out.println(student);
        student = student.getThis();
        System.out.println(student);
    }

}

class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student getThis(){
        System.out.println("返回调用该方法的对象");
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
