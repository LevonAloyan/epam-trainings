package com.epam.javatrainings.filehandling.removetmp;

import java.io.File;
/**
 * There is a directory /temp which contains files of different types and other directories
 * arbitrary nesting. It is necessary to remove files with the ".tmp" extension from it
 */
public class Main {
  public static final String DIR_PATH =
      "epam-trainings/src/com/epam/javatrainings/filehandling/removetmp/temp";

  public static void main(String[] args) {
    //    1) Add folders and files to the temp folder
    DirctoryUtil.addFilesAndFolders(DIR_PATH); // comment out after first run

    //    2) Uncomment the code below and rerun the program, to delete all ".tmp" files
    // DirectoryCleaner cleaner = new DirectoryCleaner(".tmp");
    // cleaner.deleteFile(new File(DIR_PATH));
  }
}
