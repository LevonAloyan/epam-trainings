package com.epam.javatrainings.io.customerUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Hayk on 01.10.2021.
 */
public final class CustomerUtil {
    private CustomerUtil(){}

    public static List<Customer> readFromFile(String filePath){
        List<Customer> customers=new ArrayList<>();
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {
            while((line = br.readLine()) != null){
                customers.add(convertToCustomer(line));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        sortByScore(customers);
        return customers;
    }

    public static <T> void writeToFile(String fileName, Collection<T> collection){
        PrintWriter printWriter;
        try {
             printWriter=new PrintWriter(new File(fileName));
            for (T temp:collection) {
                printWriter.write(temp.toString());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void sortByScore(List<Customer> customers){
        customers.sort(Comparator.comparing(Customer::getScore));
    }

    public static Customer convertToCustomer(String row){
        Customer rv=new Customer();
        String[] str=row.split(",");
        rv.setName(str[0]);
        rv.setPhone(str[1]);
        rv.setScore(Integer.parseInt(str[2].replace(" ","")));
        return rv;
    }
}
