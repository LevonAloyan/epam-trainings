package com.epam.javatrainings.threads.timer;

final class Timer implements Runnable {
    private final Thread t;
    private final int minute;
    private final int second;

    public Timer(int minute, int second) {
        this.minute = minute;
        this.second = second;
        t = new Thread(this);
    }

    public Thread getThread() {
        return t;
    }

    @Override
    public void run() {
        int seconds = 60 * minute + second;
        while (seconds > 0) {
            System.out.printf("%d:%d%n", seconds / 60,  seconds % 60);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            seconds--;
        }

        System.out.printf("%d:%d - %s%n", 0, 0, "The time is over");
    }

    public void start() {
        t.start();
    }
}