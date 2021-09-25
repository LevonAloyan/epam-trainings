package com.epam.javatrainings.timer.counter;

import com.epam.javatrainings.timer.exception.TimerInterruptedException;

public class SecondsCounter extends Counter {
  private static final int SLEEP_TIME = 1000; // in milliseconds
  private static final int DEFAULT_VALUE = 59;

  public SecondsCounter(int seconds) {
    super(seconds);
  }

  public SecondsCounter() {
    this(DEFAULT_VALUE);
  }

  @Override
  public void run() {
    while (getValue() >= 0) {
      System.out.print(obtainFormattedValueThenDecrement());
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
        throw new TimerInterruptedException("Seconds counter was unexpectedly interrupted");
      }
    }
    Thread.currentThread().interrupt();
  }
}
