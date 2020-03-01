package com.zozospider.java8.inter;

import org.junit.Test;

public class Son1Test {

    /**
     * 类优先原则
     */
    @Test
    public void funcTest() {
        Son1 son1 = new Son1();
        System.out.println(son1.func());
        // I am Father1.func()
    }

}
