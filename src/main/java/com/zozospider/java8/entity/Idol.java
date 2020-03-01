package com.zozospider.java8.entity;

import java.util.Optional;

public class Idol {

    private Optional<String> optionalName = Optional.empty();

    public Idol() {
        super();
    }

    public Idol(Optional<String> optionalName) {
        this.optionalName = optionalName;
    }

    public Optional<String> getOptionalName() {
        return optionalName;
    }

    public void setOptionalName(Optional<String> optionalName) {
        this.optionalName = optionalName;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "optionalName=" + optionalName +
                '}';
    }

}
