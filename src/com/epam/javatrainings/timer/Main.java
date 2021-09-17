package com.epam.javatrainings.timer;

import com.epam.javatrainings.timer.counter.Counter;
import com.epam.javatrainings.timer.counter.MinutesCounter;

public class Main {
  public static void main(String[] args) {
    Timer timer = new Timer(1, 8);
    timer.countDown();
  }
}
