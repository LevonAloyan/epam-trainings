package com.epam.javatrainings.io.taskthree;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

  private static final String PATH_ROOT = "C:\\Users\\Admin\\IdeaProjects\\epam-trainings\\temp";
  private static final String EXTENSION_FILE = ".tmp";

  public static void main(String[] args) {

    Path path = Paths.get(PATH_ROOT);
    try {
      FileManipulator.removeFileByExtension(path, EXTENSION_FILE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
