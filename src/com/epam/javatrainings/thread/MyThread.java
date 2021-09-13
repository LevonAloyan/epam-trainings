package com.epam.javatrainings.thread;

class Timer implements Runnable {
  int hours;
  int minutes;
  int seconds;

  public Timer(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  @Override
  public void run() {
    for (int i = hours; i >= 0; i--) {
      for (int j = minutes; j >= 0; j--) {
        for (int k = seconds; k >= 0; k--) {

          if (k == 0 && j == 0 && i == 0) {
            System.out.println("Finished");
            try {
              this.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          try {
            System.out.println("-  " + i + ":" + j + ":" + k + "  -");
            if (k == 0) {
              k = 60;
              j--;
            }
            if (j == 0) {
              j = 60;
              i--;
            }
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}

public class MyThread {
  public static void main(String[] args) {
    Timer timer = new Timer(6, 24, 4);
    timer.run();
  }
}
