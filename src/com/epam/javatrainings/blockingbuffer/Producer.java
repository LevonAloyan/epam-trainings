package com.epam.javatrainings.blockingbuffer;

import java.util.function.Supplier;

public class Producer<T> extends Thread {
    private static int count = 0;

    private final BoundedBlockingBuffer<T> buffer;
    private final Supplier<T> supplier;

    public Producer(String name, BoundedBlockingBuffer<T> buffer, Supplier<T> supplier) {
        super(name);
        this.buffer = buffer;
        this.supplier = supplier;
        start();
        synchronized (Producer.class) {
            count++;
            System.out.println("Producer_count = " + count);
        }
    }

    @Override
    public void run() {
        System.out.println(getName() + " starts");

        for (int i = 0; i < 5; i++) {
            T value = supplier.get();
            buffer.put(value);
        }

        synchronized (Producer.class) {
            count--;
            System.out.println("Producer_count = " + count);
            if (count == 0) {
                buffer.setFinish(true);
            }
        }

        System.out.println(getName() + " ends");
    }
}
