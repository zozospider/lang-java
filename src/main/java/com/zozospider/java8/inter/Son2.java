package com.zozospider.java8.inter;

public class Son2 implements Inter1, Inter2 {

    @Override
    public void normal() {
        System.out.println("nothing");
    }

    @Override
    public String func() {
        System.out.println("I am Son2.func()");
        return Inter2.super.func();
    }

}
