package com.xd.inf;

@FunctionalInterface
public interface MyFunctionInf<T, TestFuncInterface, R> {

    R apply(T t, TestFuncInterface u);

}
