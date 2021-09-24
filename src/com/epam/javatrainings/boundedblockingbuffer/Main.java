package com.epam.javatrainings.boundedblockingbuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  static List<Object> buffer = new ArrayList<>(1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        buffer.add(0,scanner.nextInt());

        MyThread1 myThread1= new MyThread1();
        MyThread2 myThread2 = new MyThread2();

            myThread1.start();
            myThread2.start();


    }
}
