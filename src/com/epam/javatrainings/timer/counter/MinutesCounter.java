package com.epam.javatrainings.timer.counter;

import com.epam.javatrainings.timer.exception.TimerInterruptedException;

public class MinutesCounter extends Counter {
  private static final int SLEEP_TIME = 60 * 1000; // in milliseconds
  private final int seconds;

  public MinutesCounter(int minutes, int seconds) {
    super(minutes);
    this.seconds = seconds;
  }

  @Override
  public void run() {
    int sleepTime = (seconds + 1) * 1000; // initial sleep time in milliseconds
    SecondsCounter subCounter = new SecondsCounter(seconds);
    while (getValue() >= 0) {
      System.out.print(obtainFormattedValueThenDecrement("\r", ":  "));
      new Thread(subCounter).start();
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        throw new TimerInterruptedException("Minutes counter was unexpectedly interrupted");
      }
      subCounter = new SecondsCounter();
      sleepTime = SLEEP_TIME;
    }
    Thread.currentThread().interrupt();
  }
}
