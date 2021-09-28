package com.epam.javatrainings.io.taskone;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IOUtil {

  private static final int DEFAULT_SIZE = 1024;

  public static void copyPage(String url, String filename) {
    try (InputStream inputStream = new URL(url).openStream();
        FileOutputStream outputStream = new FileOutputStream(filename)) {
      byte[] data = inputStream.readAllBytes();
      outputStream.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copyPage(String url, String filename, int bufferSizeInKb) {

    try (InputStream inputStream = new URL(url).openStream();
        FileOutputStream outputStream = new FileOutputStream(filename)) {
      byte[] dataBuffer = new byte[bufferSizeInKb * DEFAULT_SIZE];
      int bytesRead;
      while ((bytesRead = inputStream.read(dataBuffer, 0, bufferSizeInKb * DEFAULT_SIZE)) != -1) {
        outputStream.write(dataBuffer, 0, bytesRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
