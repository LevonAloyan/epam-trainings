package com.epam.javatrainings.boundedblockingbuffer;

import static java.lang.Thread.sleep;

public final class BoundedBlockingBuffer<T> {
  private T data;
  private volatile boolean valueSet = false;

  public void setData(T data) {
    this.data = data;
  }

  public void setValueSet(boolean valueSet) {
    this.valueSet = valueSet;
  }

  public synchronized T take() {
    while (!valueSet)
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    System.out.println(Thread.currentThread().getName() + " Take" + " " + data);
    setValueSet(false);
    notifyAll();

    try {
      sleep(1000); // methot sleep for test
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return data;
  }

  public synchronized void put(T data) {
    while (valueSet)
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    setValueSet(true);
    setData(data);
    System.out.println(Thread.currentThread().getName() + " Put" + " " + data);
    notifyAll();

    try {
      sleep(1000); // methot sleep for test
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
