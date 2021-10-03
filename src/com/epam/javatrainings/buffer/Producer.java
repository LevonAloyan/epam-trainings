package com.epam.javatrainings.buffer;

import java.util.List;

public class Producer<T> implements Runnable{
    private BoundedBlockingBuffer<T> buffer;
    private List<T> dataList;
    public Thread thread;

    Producer(BoundedBlockingBuffer<T> buffer, List<T> values) {
        this.buffer = buffer;
        this.dataList = values;
        thread = new Thread(this, "ProducerThread");
        thread.start();
    }

    @Override
    public void run() {
        for(T t : dataList) {
            buffer.put(t);
        }
    }
}
