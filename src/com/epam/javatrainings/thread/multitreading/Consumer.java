package com.epam.javatrainings.thread.multitreading;

public class Consumer<T> extends Thread {
  volatile BoundedBlockingBuffer<T> buffer;
  private T t = null;

  public Consumer(BoundedBlockingBuffer<T> buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
      try {
        this.t = buffer.take();
        System.out.println(Thread.currentThread().getName() + " took " + t);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    }
  }
