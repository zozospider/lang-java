package com.zozospider.java8.inter;

import org.junit.Test;

public class Son1Test {

    /**
     * 类优先原则
     */
    @Test
    public void defaultFuncTest() {
        Son1 son1 = new Son1();
        System.out.println(son1.defaultFunc());
        // I am Father1.defaultFunc()
    }

    @Test
    public void staticFuncTest() {
        Inter1.staticFunc();
        // I am Inter1.staticFunc()
    }

}
