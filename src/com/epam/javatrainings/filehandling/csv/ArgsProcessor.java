package com.epam.javatrainings.filehandling.csv;

import java.io.File;

public class ArgsProcessor {
  public static final String BASE_PATH =
      "epam-trainings/src/com/epam/javatrainings/filehandling/csv/";
  private final String[] args;

  public ArgsProcessor(String[] args) {
    this.args = args;
  }

  private boolean isEmpty() {
    return args.length == 0;
  }

  private boolean isFirstElementNull() {
    return args[0] == null;
  }

  public File getFile() {
    if (isEmpty() || isFirstElementNull()) {
      throw new IllegalArgumentException("Array of strings containing csv file name is required");
    }
    File file = new File(BASE_PATH.concat(args[0]));
    if (!file.exists()) {
      throw new IllegalArgumentException("Please provide a valid file name");
    }
    return file;
  }
}
