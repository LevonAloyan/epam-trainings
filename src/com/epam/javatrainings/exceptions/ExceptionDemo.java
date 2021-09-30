package com.epam.javatrainings.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionDemo {

    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        int read = exceptionDemo.read();
        System.out.println(read);

    }


    public int read() {
        InputStream inputStream = null;
        try {
             inputStream = new FileInputStream("java.txt");
             return 123;
        } catch (FileNotFoundException e) {
            System.out.println("Catch");
            return 0;
        }finally {
            System.out.println("Finally");
        }
    }
}
