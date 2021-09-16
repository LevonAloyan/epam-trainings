package com.epam.javatrainings.buffer;

public class Consumer <T> extends Thread {

    private BoundedBlockingBuffer<T> bbb;
    private T data;
    private String name;

    public Consumer(BoundedBlockingBuffer<T> bbb,String name){
        this.bbb=bbb;
        this.name=name;
    }

    @Override
    public void run(){
        data= (T) bbb.take(name);
        System.out.println();
    }

}
