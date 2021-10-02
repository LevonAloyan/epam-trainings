package com.epam.javatrainings.thread.multitreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.currentThread;

public class BoundedBlockingBuffer<T> {
  private final BlockingQueue<T> queue;
  private volatile boolean isActive;
  private T temp;

  public BoundedBlockingBuffer(int capacity) {
    this.queue = new ArrayBlockingQueue<>(capacity);
  }

  public synchronized T take() throws InterruptedException {

    if (!isActive || queue.isEmpty()) {

      System.out.println(currentThread().getName() + " is waiting");
      wait (1000);
      notifyAll();
    } else {
      temp = queue.peek();
      System.out.println(temp + " is taken");
      isActive = false;
      notifyAll();
    }
    return temp;
  }

  public synchronized void put(T data) {
    if (isActive) {
      try {
        System.out.println(currentThread().getName() + " is waiting");
        wait();
        notifyAll();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {

      try {
        queue.put(data);
        isActive = true;
        notifyAll();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
