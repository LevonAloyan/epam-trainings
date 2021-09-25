package com.epam.javatrainings.threads.timer;

import javax.swing.*;
import java.awt.*;

public class Timer implements Runnable {
    private int minute;
    private int second;

    public Timer(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public void run() {
        while (second >= 0 && minute <= 59) {
            System.out.printf("%02d:%02d\n", minute, second);
            Toolkit.getDefaultToolkit().beep();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            second--;
            if (second == -1 && minute != 0) {
                second = 59;
                minute -= 1;
            }
        }
    }
}
