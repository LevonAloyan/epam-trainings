package com.epam.javatrainings.input_output_task_homework.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static final String URL = "http://example.com";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input html file path");
        String outputPathForByteByByte = scanner.nextLine();
        try {
            copyingByteByByte(outputPathForByteByByte);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Please input html file path");
        String outputPathFor8kbBuffer = scanner.nextLine();
        try {
            copying8kbBuffer(outputPathFor8kbBuffer);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void copying8kbBuffer(String outputPath) throws MalformedURLException {
        URL url = new URL(URL);

        try (InputStream inputStream = url.openStream();
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
        ) {
            byte[] buffer = new byte[8192];
            int numBytesRead;
            while ((numBytesRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
                fileOutputStream.write(buffer, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyingByteByByte(String outputPath) throws MalformedURLException {
        URL url = new URL(URL);
        int numBytesRead;

        try (InputStream inputStream = url.openStream();
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
        ) {
            while ((numBytesRead = inputStream.read()) != -1) {
                fileOutputStream.write(numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
