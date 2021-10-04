package com.epam.javatrainings.classdecomposition.generator;

public final class OrderNumberGenerator {
    private static long current = 10000;

    public static long next() {
        return ++current;
    }

    private OrderNumberGenerator() {

    }
}
