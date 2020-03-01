package com.zozospider.java8.inter;

public interface Inter1 {

    void normal();

    default String func() {
        return "I am Inter1.func()";
    }

}
