package test.xd.test;

public class MyOverload {

    private void test1(){

    }

    private void test1(int x){

    }

    protected static void test1(int y, int z){

    }

    //编译报错  重载不正确
    //public int test1(){
    //    return 1;
    //}
    //
    ////编译报错  重载不正确
    //public double test1(){
    //    return 2.0;
    //}
}
