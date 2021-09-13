package com.epam.javatrainings.thread.countersize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.String.format;

public class SizeCount {

  public static void main(String[] args) {

    Path path = Paths.get("out");
    AtomicLong size = new AtomicLong();

    Thread fileSize =
        new Thread(
            () -> {
              try {
                size.set(
                    Files.walk(path)
                        .filter(p -> p.toFile().isFile())
                        .mapToLong(p -> p.toFile().length())
                        .sum());
                System.out.print(format("The directory(file) size is %s bytes", size));
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
    fileSize.start();
  }
}
