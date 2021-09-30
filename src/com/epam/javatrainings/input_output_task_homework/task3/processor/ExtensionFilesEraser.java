package com.epam.javatrainings.input_output_task_homework.task3.processor;

import java.io.File;
import java.util.Objects;

public class ExtensionFilesEraser {
    public static void eraseExtensionFiles(String pathFolder, String extension) {
        File file = new File(pathFolder);
        File[] files = file.listFiles();
        for (File f : Objects.requireNonNull(files)) {
            if (f.isDirectory()) {
                eraseExtensionFiles(f.toString(), extension);
            }
            int index = f.toString().lastIndexOf(".");
            String fileExtension = f.toString().substring(index + 1);
            if (fileExtension.equals(extension)) {
                f.deleteOnExit();
            }
        }
    }
}
