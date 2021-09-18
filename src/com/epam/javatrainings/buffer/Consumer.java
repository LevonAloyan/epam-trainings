package com.epam.javatrainings.buffer;

import java.util.List;

public class Consumer<T> implements Runnable {
    private BoundedBlockingBuffer<T> buffer;
    private List<T> dataList;
    public Thread thread;


    Consumer(BoundedBlockingBuffer<T> buffer, List<T> values) {
        this.buffer = buffer;
        this.dataList = values;
        thread = new Thread(this, "ConsumerThread");
        thread.start();
    }

    @Override
    public void run() {
        for(T t : dataList) {
            buffer.take();
        }
    }
}
