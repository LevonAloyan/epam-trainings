package com.epam.javatrainings.thread.multitreading;

public class Producer<T> extends Thread {
  volatile BoundedBlockingBuffer<Integer> buffer;

    public Producer(BoundedBlockingBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      try {
      buffer.put(i);
      System.out.println(Thread.currentThread().getName() + " put " + i );

        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace ();
      }
    }
  }
}
