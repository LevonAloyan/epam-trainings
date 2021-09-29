package com.epam.javatrainings.bounded_blocking_buffer;

import com.epam.javatrainings.bounded_blocking_buffer.persistance.Human;
import com.epam.javatrainings.bounded_blocking_buffer.service.BoundedBlockingBuffer;
import com.epam.javatrainings.bounded_blocking_buffer.service.BoundedBufferThread;

public class TestBoundedBuffer {
    public static void main(String[] args) {
        BoundedBlockingBuffer<String> boundedBlockingBuffer = new BoundedBlockingBuffer<>();

        Human human1 = new Human("Human1");
        Human human2 = new Human("Human2");

        BoundedBufferThread<String> firstThread = new BoundedBufferThread<>(human2.getName(),boundedBlockingBuffer);
        BoundedBufferThread<String> secondThread = new BoundedBufferThread<>(human1.getName(),boundedBlockingBuffer);

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(args[0]);

        System.out.println("The main thread is ended");
    }
}
