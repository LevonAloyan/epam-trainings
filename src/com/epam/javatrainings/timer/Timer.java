package com.epam.javatrainings.timer;

import com.epam.javatrainings.timer.counter.Counter;
import com.epam.javatrainings.timer.counter.MinutesCounter;
import com.epam.javatrainings.timer.exception.TimerInterruptedException;

public class Timer {
  private final int minutes;
  private final int seconds;

  private Timer(TimerBuilder timerBuilder) {
    minutes = timerBuilder.minutes;
    seconds = timerBuilder.seconds;
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

  public static class TimerBuilder {
    private final int minutes;
    private final int seconds;

    public TimerBuilder(int minutes, int seconds) {
      this.minutes = minutes;
      this.seconds = seconds;
    }

    public Timer build() {
      if (!(minutes >= 0 && minutes < 60 && seconds >= 0 && seconds < 60)) {
        throw new IllegalArgumentException(
            "Invalid Timer arguments. Please provide valid int numbers in range [0-59]");
      }
      return new Timer(this);
    }
  }
}
