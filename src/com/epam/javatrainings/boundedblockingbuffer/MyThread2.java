package com.epam.javatrainings.boundedblockingbuffer;

public class MyThread2 extends Thread{

    BoundedBlockingBuffer<Object> boundedBlockingBuffer = new BoundedBlockingBuffer<>();
    @Override
    public void run() {
        boundedBlockingBuffer.take();
    }
}
