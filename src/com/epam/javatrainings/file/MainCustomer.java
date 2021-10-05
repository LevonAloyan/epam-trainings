package com.epam.javatrainings.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainCustomer {
    public static void main(String[] args) {

        InputStreamReader inputStream = null;
        FileOutputStream fileOutputStream = null;
        Writer writer=null;
        File file = null;
        System.out.println(args[0]);
        if (args.length > 0) {
            file = new File(args[0]);
        }

        if (file != null) {
            try {
                inputStream = new InputStreamReader(new FileInputStream(file));
//                fileOutputStream = new FileOutputStream("custumerone.txt");
                writer=new BufferedWriter(new FileWriter("custumerone.txt"));

                int x;
                StringBuilder stringBuilder = new StringBuilder();
                while ((x = inputStream.read()) != -1) {
                    stringBuilder.append((char) x);

                }
//                System.out.println(stringBuilder);
                String[] str = stringBuilder.toString().split(",|\\R");
                List<Customer> customers = new ArrayList<>();
                System.out.println(Arrays.toString(str));
                for (int i = 0; i <= str.length - 3; i = i + 3) {
                    Customer customer = new Customer(str[i], str[i + 1], Integer.parseInt(str[i + 2]));
                    customers.add(customer);
                }
                StringBuilder stringBuilders = new StringBuilder();
                System.out.println("sorted");
                System.out.println(customers.stream().sorted(Comparator.comparing(Customer::getScore)).map(String::valueOf).collect(Collectors.joining()));
                String sor = customers.stream().sorted(Comparator.comparing(Customer::getScore)).map(String::valueOf).collect(Collectors.joining());
                writer.write(sor);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
