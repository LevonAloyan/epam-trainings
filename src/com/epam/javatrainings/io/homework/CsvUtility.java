package com.epam.javatrainings.io.homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvUtility {
    public static List<Customer> readCustomersFrom(String path){
        try(FileReader fr = new FileReader(path)){
            BufferedReader br= new BufferedReader(fr);
            List<Customer> list = new ArrayList ();
            String str;
            while((str =br.readLine())!= null){
//                String[] customers = str.split(" \n ");
//                list.add(new Customer(customers[0].trim(),))
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return null;
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
    public static void sort(List<Customer> customers){
        Collections.sort(customers);
    }
}
