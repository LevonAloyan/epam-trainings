package com.epam.javatrainings.filehandling.removetmp;

import com.epam.javatrainings.filehandling.downloadhtml.FileManipulationException;

import java.io.File;
import java.util.Random;
import java.io.IOException;

public class DirctoryUtil {
  private static final String[] EXTENSIONS = {
    ".txt", ".tmp", ".csv", ".pdf", ".xls", ".html", ".js", ".java", ".class", ".py"
  };
  public static final String[] FRUIT = {
    "Apple",
    "Apricot",
    "Avocado",
    "Banana",
    "Blackberry",
    "Blueberry",
    "Cherry",
    "Coconut",
    "Cucumber",
    "Durian"
  };

  private static void addSubDirsAndFiles(File root, String[] fruitNames, int depth) {
    if (depth == 0) return;

    for (String f : FRUIT) {
      File subdir = new File(root, FRUIT[new Random().nextInt(FRUIT.length)]);
      subdir.mkdir();
      for (String s : EXTENSIONS) {
        try {
          new File(subdir.toString().concat(EXTENSIONS[new Random().nextInt(EXTENSIONS.length)]))
              .createNewFile();
        } catch (IOException e) {
          throw new FileManipulationException("Failed to create fruit file", e.getCause());
        }
      }
      addSubDirsAndFiles(subdir, fruitNames, depth - 1);
    }
  }

  public static void addFilesAndFolders(String path) {
    addSubDirsAndFiles(new File(path), FRUIT, 3);
  }
}
