package com.epam.javatrainings.filehandling.removetmp;

import java.io.File;
import java.util.Arrays;

public class DirectoryCleaner {
  private final String extension;

  public DirectoryCleaner(String extension) {
    this.extension = extension;
  }

  public void deleteFile(File file) {
    if (!file.exists()) {
      throw new IllegalArgumentException("Please provide a valid file");
    }
    if (file.isDirectory()) {
      Arrays.stream(file.listFiles()).forEach(this::deleteFile);
    }
    if (file.toString().endsWith(extension)) {
      file.delete();
    }
  }
}
