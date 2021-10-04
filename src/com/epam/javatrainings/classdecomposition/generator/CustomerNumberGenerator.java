package com.epam.javatrainings.classdecomposition.generator;

public final class CustomerNumberGenerator {
    private static long current = 10000;

    public static long next() {
        return ++current;
    }

    private CustomerNumberGenerator() {

    }
}
