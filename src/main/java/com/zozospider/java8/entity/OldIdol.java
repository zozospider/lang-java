package com.zozospider.java8.entity;

public class OldIdol {

    private String name;

    public OldIdol() {
        super();
    }

    public OldIdol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OldIdol{" +
                "name='" + name + '\'' +
                '}';
    }

}
