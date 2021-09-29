package com.epam.javatrainings.iohomework.task3;

import java.io.File;

public class Main {

    public static boolean removeFile(String path, String extension) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        boolean isDeleted = false;
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    isDeleted = removeFile(file.getPath(), extension);
                } else {
                    if (file.getName().endsWith(extension)) {
                        isDeleted = file.delete();
                    }
                }

            }
        }
        return isDeleted;
    }

    public static void main(String[] args) {

        boolean isDeleted = removeFile("temp", ".tmp");
        System.out.println(isDeleted);

    }
}
