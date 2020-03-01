package com.zozospider.java8.inter;

public class Son2 implements Inter1, Inter2 {

    @Override
    public void normal() {
        System.out.println("I am Son2.normal()");
        System.out.println(Inter1.super.defaultFunc());
    }

    /**
     * 调用两个接口的相同默认接口时, 需要指定具体的接口名称
     */
    @Override
    public String defaultFunc() {
        System.out.println("I am Son2.defaultFunc()");
        return Inter2.super.defaultFunc();
    }

}
