package com.zozospider.java8.entity;

import java.util.Optional;

public class Man {

    private Optional<String> optionalName = Optional.empty();
    private Optional<Idol> optionalIdol = Optional.empty();

    public Man() {
        super();
    }

    public Man(Optional<String> optionalName) {
        this.optionalName = optionalName;
    }

    public Man(Optional<String> optionalName, Optional<Idol> optionalIdol) {
        this.optionalName = optionalName;
        this.optionalIdol = optionalIdol;
    }

    public Optional<String> getOptionalName() {
        return optionalName;
    }

    public void setOptionalName(Optional<String> optionalName) {
        this.optionalName = optionalName;
    }

    public Optional<Idol> getOptionalIdol() {
        return optionalIdol;
    }

    public void setOptionalIdol(Optional<Idol> optionalIdol) {
        this.optionalIdol = optionalIdol;
    }

    @Override
    public String toString() {
        return "Man{" +
                "optionalName=" + optionalName +
                ", optionalIdol=" + optionalIdol +
                '}';
    }

}
