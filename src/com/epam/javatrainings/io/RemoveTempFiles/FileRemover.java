package com.epam.javatrainings.io.RemoveTempFiles;


import java.io.File;

public class FileRemover {

    public void removeFileByExtension(String filePath, String extension) {
        File file = new File(filePath);
        for(File f : file.listFiles()) {
            if(f.isFile() && f.getName().endsWith(extension)) {
                f.delete();
            } else if(f.isDirectory()) {
                removeFileByExtension(f.getPath(), extension);
            }
        }

    }
}
