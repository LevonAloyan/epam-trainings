package com.epam.javatrainings.boundedblockingbuffer;

public class Main {

  public static void main(String[] args) {

    // example data
    Integer transferredData = 100;
    BoundedBlockingBuffer<Integer> buffer = new BoundedBlockingBuffer<>();

    // add data in buffer
    Thread t1 = new Thread(() -> buffer.put(transferredData), "T1");
    t1.start();

    // take data from buffer
    Thread t2 = new Thread(() -> buffer.take(), "T2");
    t2.start();
  }
}
