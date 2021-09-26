package com.epam.javatrainings.bounded_blocking_buffer.service;

public class BoundedBlockingBuffer<T> {
    private T data;
    private boolean emptyBuffer;


    public synchronized void put(T data){
        String threadNameAndId = String.format("Thread name: %s, thread id: %s",
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
        while (emptyBuffer){
            System.out.printf("Buffer already contains some value and this thread waits: %s",
                    threadNameAndId);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%s data: %s \n",threadNameAndId, data);
        this.data = data;
        emptyBuffer = true;
    }

    public synchronized T take(){
        String threadNameAndId = String.format("Thread name: %s, thread id: %s",
                Thread.currentThread().getName(),
                Thread.currentThread().getId());
        while (!emptyBuffer){
            try {
                System.out.printf("Buffer does not contain any value and this thread waits,until someone will put a value %s",
                        threadNameAndId);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%s thread picked up its value,and this is the data: %s. Now thread is empty. \n",threadNameAndId, data);
        emptyBuffer = false;
        notifyAll();
        return data;
    }
}
