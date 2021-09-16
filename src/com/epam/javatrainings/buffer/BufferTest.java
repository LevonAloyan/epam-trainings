package com.epam.javatrainings.buffer;

public class BufferTest {
    public static void main(String[] args){
        BoundedBlockingBuffer<Integer> bbb=new BoundedBlockingBuffer<Integer>();
        Consumer<Integer> consumer1=new Consumer<Integer>(bbb,"Consumer1 ");
        consumer1.start();
        Consumer<Integer> consumer2=new Consumer<Integer>(bbb,"Consumer2 ");
        consumer2.start();
        Consumer<Integer> consumer3=new Consumer<Integer>(bbb,"Consumer3 ");
        consumer3.start();
        Producer<Integer> producer1=new Producer<>(bbb,"Producer1 ",1);
        producer1.start();
        Producer<Integer> producer2=new Producer<>(bbb,"Producer2 ",2);
        producer2.start();
        Producer<Integer> producer3=new Producer<>(bbb,"Producer3 ",3);
        producer3.start();


    }
}
