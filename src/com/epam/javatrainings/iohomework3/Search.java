package com.epam.javatrainings.iohomework3;

import java.io.File;
import java.util.ArrayList;

public class Search {
    private File filePath;
    private String fileExtToSearch;
    private ArrayList<File> foundedFiles=new ArrayList<>();

    public Search(File filepath, String fileExtToSearch){
        this.filePath=filePath;
        this.fileExtToSearch=fileExtToSearch;
        startSearch(filepath);
        showResultsAndDelete();
    }

    public  void startSearch(File filePath){
        for(File file: filePath.listFiles() ){
            if(file.isDirectory()) {
                startSearch(file);
            }else{
                String path= file.getAbsolutePath();
                String extension=path.substring(path.lastIndexOf("."));
                if(extension.equals(fileExtToSearch)){
                    foundedFiles.add(file);
                }
            }
        }
    }
    public void showResultsAndDelete(){
        if(foundedFiles.isEmpty()){
            System.out.println(("Nothing was found!"));
        }
        else {
            System.out.println(("Founded results are: "));
            for (File file : foundedFiles) {
                System.out.println(file.getAbsolutePath());
                //file.delete();
            }
        }
    }


}
