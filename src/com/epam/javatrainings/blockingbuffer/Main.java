package com.epam.javatrainings.blockingbuffer;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        BoundedBlockingBuffer<Integer> buffer = new BoundedBlockingBuffer<>(4);
        Supplier<Integer> supplier = () -> new Random().nextInt(99);
        Producer<Integer> producer1 = new Producer<>("Producer_1", buffer, supplier);
        Producer<Integer> producer2 = new Producer<>("Producer_2", buffer, supplier);
        Producer<Integer> producer3 = new Producer<>("Producer_3", buffer, supplier);
        Consumer<Integer> consumer1 = new Consumer<>("Consumer_1", buffer);
        Consumer<Integer> consumer2 = new Consumer<>("Consumer_2", buffer);
        Consumer<Integer> consumer3 = new Consumer<>("Consumer_3", buffer);
    }
}
