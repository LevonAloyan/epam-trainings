package com.epam.javatrainings.csv.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    private CsvReader() {

    }

    public static List<String> getFields(String line) {
            return Arrays.asList(line.split(","));
    }

    public static List<String> readAllCustomersFromCsv(String filePath) {
        List<String> allLines = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String fields;
            while((fields= bufferedReader.readLine())!=null){
                allLines.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Can't read from file IN CSV READER");
        } finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Cant close Buffered reader");
            }
        }
        return allLines;
    }
}
