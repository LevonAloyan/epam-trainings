package com.epam.javatrainings.thread.blockingBuffer;

/**
 * Created by Hayk on 16.09.2021.
 */
public class ExampleTest {
    public static void main(String[] args) {
        BoundedBlockingBuffer<String> boundedBlockingBuffer=new BoundedBlockingBuffer<>();
        String value="mail";
        Producer<String> producer=new Producer<>(boundedBlockingBuffer,value);
        Consumer<String> consumer=new Consumer<>(boundedBlockingBuffer);

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
