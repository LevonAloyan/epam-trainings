package com.epam.javatrainings.io.removetmp;

import java.io.File;

public class FileRemover {
    private FileRemover() {
        throw new IllegalStateException("No instances");
    }

    public static void removeFiles(String folderPath, String extension) {
        File folder = new File(folderPath);

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                removeFiles(fileEntry + "/", extension);
            } else {
                if (fileEntry.toString().endsWith(extension)) {
                    fileEntry.delete();
                }
            }
        }
    }
}
