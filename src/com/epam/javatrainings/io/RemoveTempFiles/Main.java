package com.epam.javatrainings.io.RemoveTempFiles;

public class Main {

    public static void main(String[] args) {

        // for testing
        String filePath = "/Users/eminter-mkrtchyan/desktop/temp";

        FileRemover fm = new FileRemover();

        fm.removeFileByExtension(filePath, ".tmp");
    }
}
