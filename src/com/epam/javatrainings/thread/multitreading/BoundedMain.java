package com.epam.javatrainings.thread.multitreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BoundedMain {
  public static void main(String[] args) {
    BoundedBlockingBuffer<Integer> buffer = new BoundedBlockingBuffer<>(10);
    buffer.put(12);
    buffer.put(13);
    Producer producer = new Producer<Integer>(buffer);
    Consumer consumer = new Consumer<>(buffer);

    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(producer);
    executor.submit(consumer);


//    producer.start();
//    consumer.start();
//
//      try {
//        producer.join();
//        consumer.join();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }

