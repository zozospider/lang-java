package com.zozospider.java8.inter;

public interface Inter2 {

    /**
     * 接口的默认方法
     */
    default String defaultFunc() {
        return "I am Inter2.defaultFunc()";
    }

    /**
     * 接口的静态方法
     */
    static void staticFunc() {
        System.out.println("I am Inter2.staticFunc()");
    }

}
