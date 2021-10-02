package com.epam.javatrainings.IO.task_3;

import java.io.File;

public class Main {
    public static void main(String[] args) {

    File folder = new File("src/com/epam/javatrainings/IO/task_3/files");
    File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(".temp")) {
                new File(String.valueOf(f.delete()));
            }
        }
    }
}
