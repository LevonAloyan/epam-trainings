package com.epam.javatrainings.homework_7.Task3;

import java.io.File;

public class FileRemover {
    public static void Remove(String path, String extension){
        File file = new File(path);
        File [] files = file.listFiles((d, f) -> f.toLowerCase().endsWith(extension));

        assert files != null;
        for (File f : files) {
           if(f.delete()){
               System.out.println(f.getName() + "   deleted successfully.");
           }
        }

    }
}
