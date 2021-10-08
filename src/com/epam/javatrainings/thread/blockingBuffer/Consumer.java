package com.epam.javatrainings.thread.blockingBuffer;

/**
 * Created by Hayk on 16.09.2021.
 */
public class Consumer<T> extends Thread {
    private final BoundedBlockingBuffer<T> boundedBlockingBuffer;
    private  T value;

    public Consumer(BoundedBlockingBuffer<T> obj){
        this.boundedBlockingBuffer=obj;
        new Thread(this).start();
    }

    @Override
    public void run(){
            value=boundedBlockingBuffer.peek();
    }
}
