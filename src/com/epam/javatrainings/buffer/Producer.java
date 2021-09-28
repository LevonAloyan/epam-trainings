package com.epam.javatrainings.buffer;

public class Producer <T> extends Thread{

    private BoundedBlockingBuffer<T> bbb;
    private String name;
    private T data;

    public Producer(BoundedBlockingBuffer<T> bbb, String name, T data){
        this.bbb=bbb;
        this.name=name;
        this.data=data;
    }

    @Override
    public void run() {
        bbb.put( data, name);
    }

}