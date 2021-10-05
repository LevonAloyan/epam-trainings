package com.epam.javatrainings.file;

import java.io.File;

public class RemoveFile {
    public static void main(String[] args) {
        boolean removes =removefile(".tmp",".tmp");
        System.out.println(removes);

    }

    public static boolean removefile(String temp, String direct) {
        File file = new File(temp);
        File[] files = file.listFiles();
        boolean removes = false;
        if (files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    removes = removefile(file1.getPath(), direct);
                } else if(file1.getName().endsWith(direct)){
                    removes=file1.delete();
                }
            }
        }
        return removes;
    }
}
