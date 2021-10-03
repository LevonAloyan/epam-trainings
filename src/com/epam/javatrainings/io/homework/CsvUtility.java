package com.epam.javatrainings.io.homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvUtility {
    public static List<Customer> readCustomersFrom(String path){
        List<Customer> list = new ArrayList ();
        try(FileReader fr = new FileReader(path)){
            BufferedReader br= new BufferedReader(fr);
            String str;
            while((str =br.readLine())!= null){
                String[] customers = str.split(",");
                list.add(new Customer(customers[0].trim(),customers[1].trim(),Integer.parseInt (customers[2].trim())));
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }
        return list;
    }
    public static void writeCustomersTo(String path, List<Customer> customers){
        try{
            BufferedWriter bufferedWriter= Files.newBufferedWriter(Paths.get(path));
            for (Customer customer : customers){
                bufferedWriter.write(customer.toString()+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public static List<Customer> sort(List<Customer> customers){
        Collections.sort(customers);
        return customers;
    }
}
