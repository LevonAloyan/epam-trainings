package com.epam.javatrainings.thread.multitreading;

public class BoundedMain {
  public static void main(String[] args) {
   BoundedBlockingBuffer<Integer> buffer = new BoundedBlockingBuffer<>(4);
buffer.put (12);
      Producer producer=new Producer<Integer> (buffer);
      Consumer consumer = new Consumer<> (buffer);

      producer.start();
      consumer.start();
      try {
          producer.join();
          consumer.join();
      } catch (InterruptedException e) {
          e.printStackTrace ();
      }
  }
}
