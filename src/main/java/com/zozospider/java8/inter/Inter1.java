package com.zozospider.java8.inter;

public interface Inter1 {

    /**
     * 接口的普通方法
     */
    void normal();

    /**
     * 接口的默认方法
     */
    default String defaultFunc() {
        return "I am Inter1.defaultFunc()";
    }

    /**
     * 接口的静态方法
     */
    static void staticFunc() {
        System.out.println("I am Inter1.staticFunc()");
    }

}
