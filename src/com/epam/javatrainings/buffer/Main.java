package com.epam.javatrainings.buffer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Neo");
        strings.add("Trinity");
        strings.add("Morpheus");
        strings.add("Agent Smith");

        BoundedBlockingBuffer<String> buffer = new BoundedBlockingBuffer<>();

        Producer<String> producer = new Producer<>(buffer, strings);
        Consumer<String> consumer = new Consumer<>(buffer, strings);

        try {
            producer.thread.join();
            consumer.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
