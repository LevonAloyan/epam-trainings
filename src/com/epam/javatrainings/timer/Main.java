package com.epam.javatrainings.timer;

import com.epam.javatrainings.timer.counter.Counter;
import com.epam.javatrainings.timer.counter.MinutesCounter;

public class Main {
  public static void main(String[] args) {
    Timer timer = new Timer.TimerBuilder(1, 11).build();
    timer.countDown();
  }
}
