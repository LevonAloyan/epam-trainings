package com.epam.javatrainings.io.homework;

import java.io.File;
import java.util.Objects;

public class ExtensionCleaner {
    public static void erase(String path,String extension){
    File file = new File(path);
    File[] files = file.listFiles();
    for (File file1 : Objects.requireNonNull(files)) {
      if (file1.isDirectory()){
          erase(file1.toString (),extension);
      }
      int i = file1.toString ().lastIndexOf('.');
      String ext= files.toString ().substring(i+1);
      if(ext.equals(extension)){
          file1.deleteOnExit ();
      }
    }
            }
}
