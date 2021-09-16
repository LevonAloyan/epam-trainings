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

    synchronized (queue) {
      if (!isActive || queue.isEmpty()) {

        System.out.println(currentThread().getName() + " is waiting");
        notifyAll();
        Thread.sleep(1000);
      } else {

        temp = queue.peek();
        System.out.println(temp + " is taken");
        isActive = false;
        Thread.sleep(1500);
        notifyAll();
      }
    }
  return temp;
  }

  public synchronized void put(T data) {
    while (isActive) {
      synchronized (queue) {
        try {
          wait();
          System.out.println(currentThread().getName() + " is waiting");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

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
}
