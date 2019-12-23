package test.xd.test;

import java.lang.Override;

abstract class Circle extends Shape {

}

class Circle2 extends Shape{

    void draw(){

    }

    //编译报错，抽象类重写返回类型不能不同
    //int draw() {
    //
    //}
}

class Circle3 extends Shape{
    @Override
    void draw() {

    }
}
