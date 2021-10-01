package com.epam.javatrainings.boundedblockingbuffer;

public class MyThread1 extends Thread {

    BoundedBlockingBuffer<Object> boundedBlockingBuffer = new BoundedBlockingBuffer<>();

    @Override
    public void run(){
        boundedBlockingBuffer.put(Main.buffer.get(0));
    }
}
