package com.epam.javatrainings.tmpremoval;

public class Main {
    public static void main(String[] args) {
        String tmpFolder = "C:\\GEV\\Java Projects\\epam-trainings\\src\\resources\\tmp";

        //It deletes any file with .tmp extension from specified folder with its subfolders. TESTED
        TempFilesCleaner.cleanTmpFiles(tmpFolder);
    }
}
