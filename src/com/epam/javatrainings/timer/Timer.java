package com.epam.javatrainings.timer;

import com.epam.javatrainings.timer.counter.Counter;
import com.epam.javatrainings.timer.counter.MinutesCounter;
import com.epam.javatrainings.timer.exception.TimerInterruptedException;

public class Timer {
  private final int minutes;
  private final int seconds;

  public Timer(int minutes, int seconds) {
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public void countDown() {
    Counter minutesCounter = new MinutesCounter(minutes, seconds);
    Thread timer = new Thread(minutesCounter);
    timer.start();

    try {
      timer.join();
    } catch (InterruptedException e) {
      throw new TimerInterruptedException("Interrupted during timerThread join");
    }
  }
}
