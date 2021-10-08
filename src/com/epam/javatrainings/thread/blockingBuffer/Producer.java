package com.epam.javatrainings.thread.blockingBuffer;

/**
 * Created by Hayk on 16.09.2021.
 */
public class Producer<T> extends Thread{
    private final BoundedBlockingBuffer<T> boundedBlockingBuffer;
    private T value;

    public Producer(BoundedBlockingBuffer<T> obj,T value){
        this.boundedBlockingBuffer=obj;
        this.value=value;
        new Thread(this).start();
    }
    @Override
    public void run(){
        boundedBlockingBuffer.put(value);
    }
}
