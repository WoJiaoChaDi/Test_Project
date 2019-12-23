package test.xd.test;

public class MyOverride {
    private void test(){
        System.out.println("Parent private test()...");
    }

    public void test1(){
        System.out.println("Parent public test()...");
    }
}

class Child extends MyOverride {
    public void test(){
        System.out.println("Child public test()...");
    }

    //编译报错  重写不正确
    //private void test1(){
    //    System.out.println("Child private test()...");
    //}
}
