package com.epam.javatrainings.io_stream.task_3.deleteFile;

import java.io.File;

public class DeleteFile {

    public void deleteFile(String directory) {
        File file = new File(directory);
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.getName().endsWith(".tmp")) {
                f.delete();
            } else {
                System.out.println("Unable to delete!");
            }
        }
    }
}
