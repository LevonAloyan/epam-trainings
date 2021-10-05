package com.epam.javatrainings.threads.buffer;

@FunctionalInterface
public interface Producable<T> {
    T produce();
}
