package com.epam.javatrainings.classdecomposition.palmetto.enums;

public enum Type {

    REGULAR(1.0), CALZONE(0.5);

    private final double rate;

    Type(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
