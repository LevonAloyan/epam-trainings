package com.epam.javatrainings.serialization.task3;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        FileDemo fileDemo = new FileDemo();
        fileDemo.throughFiles("C:\\Users\\admin\\IdeaProjects\\homeworkOfClasses\\epam-trainings\\ahgdjhajsdJ");
    }

    public void throughFiles(String dirPath) {

        FileDemo fileDemo = new FileDemo();

        File dir = new File(dirPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isDirectory()) {
                    throughFiles(child.getPath());
                } else {
                    if (fileDemo.isTmp(child.getName())) {
                        child.delete();
                    }
                }
            }
        } else {
            System.out.println("this directory is empty");
        }
    }

    public boolean isTmp(String fullName) {
        if (fullName != null) {
            String fileName = new File(fullName).getName();
            int dotIndex = fileName.lastIndexOf('.');
            if (((dotIndex == -1) ? " " : fileName.substring(dotIndex + 1)).equals("tmp")) {
                return true;
            }
        }
        return false;
    }
}
