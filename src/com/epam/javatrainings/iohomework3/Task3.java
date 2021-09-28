package com.epam.javatrainings.iohomework3;

import java.io.File;


public class Task3 {
    public static void main(String[] args){
        File path=new File("C:\\Users\\Vache Khachatryan\\Homework1\\src");
        String neededExtension=".java";
        Search search= new Search(path,neededExtension);
    }
}
