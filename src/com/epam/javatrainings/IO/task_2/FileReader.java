package com.epam.javatrainings.IO.task_2;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class FileReader {

    public TreeSet<Customer> readFile(String filepath){
        TreeSet<Customer> customerSet = new TreeSet<>();
        try {
            File inFile = new File(filepath);
            Scanner inputFile = new Scanner(inFile);

            while (inputFile.hasNext()) {
                String s = inputFile.nextLine();
                String[]tokens = s.split(",");
                String name = tokens[0];
                String phone = tokens[1];
                int score = Integer.parseInt(tokens[2]);

                Customer customer = new Customer(name, phone, score);
                customerSet.add(customer);
        }
    }
      catch (Exception e){
          System.out.println(e);
      }
        return customerSet;
    }
}
