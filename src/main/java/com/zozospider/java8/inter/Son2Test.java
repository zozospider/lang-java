package com.zozospider.java8.inter;

import org.junit.Test;

public class Son2Test {

    @Test
    public void  defaultFuncTest() {
        Son2 son2 = new Son2();

        son2.normal();
        // I am Son2.normal()
        // I am Inter1.defaultFunc()

        System.out.println(son2.defaultFunc());
        // I am Son2.defaultFunc()
        // I am Inter2.defaultFunc()
    }

    @Test
    public void staticFuncTest() {
        Inter2.staticFunc();
        // I am Inter2.staticFunc()
    }

}
