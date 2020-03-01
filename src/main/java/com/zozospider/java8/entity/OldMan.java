package com.zozospider.java8.entity;

public class OldMan {

    private String name;
    private OldIdol idol;

    public OldMan() {
        super();
    }

    public OldMan(String name) {
        this.name = name;
    }

    public OldMan(String name, OldIdol idol) {
        this.name = name;
        this.idol = idol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OldIdol getIdol() {
        return idol;
    }

    public void setIdol(OldIdol idol) {
        this.idol = idol;
    }

    @Override
    public String toString() {
        return "OldMan{" +
                "name='" + name + '\'' +
                ", idol='" + idol + '\'' +
                '}';
    }

}
