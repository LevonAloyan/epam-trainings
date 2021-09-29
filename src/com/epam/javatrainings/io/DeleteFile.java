package io;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File sourceDir = new File("C:\\Temp");
        listFiles(sourceDir);
    }
    
    private static void listFiles(File parentDir){
        if(!parentDir.isDirectory()){
            System.out.println("Not a directory.");
            return;
        }
        File[] fileList = parentDir.listFiles();
        for(File file : fileList){
            if(file.isDirectory()){
                System.out.println("Directory- " + file.getName());
                listFiles(file);
            }else{
                if (file.getName().contains(".txt")) {
                    System.out.println("Deleting File- " + file.getName());
                    file.delete();
                }
            }
        }
    }


}
