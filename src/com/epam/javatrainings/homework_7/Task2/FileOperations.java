package com.epam.javatrainings.homework_7.Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperations {

    public static List<Customer> getData(String path){
        List<Customer> customers = new ArrayList<>();
        File file = new File(path);
        String [] temp;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                temp = sc.nextLine().split(",");
                customers.add(new Customer(temp[0], temp[1],Integer.parseInt(temp[2])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static void saveData(String path, List<Customer> customers){
        List<Customer> sortedlist = customers.stream()
                .sorted(Comparator.comparingInt(Customer::getScore))
                .collect(Collectors.toList());

        File f1 = new File(path);
        try {
            FileWriter fw = new FileWriter(f1);
            for(Customer s : sortedlist){
                fw.write(s.toString()+ System.lineSeparator());
            }
            fw.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
