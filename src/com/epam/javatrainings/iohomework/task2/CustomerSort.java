package com.epam.javatrainings.iohomework.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSort {

    public static void main(String[] args) {
        File file = null;
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        StringBuilder data = new StringBuilder();

        if (args.length > 0) {
            file = new File(args[0]);
        }

        try {
            if (file != null) {
                in = new InputStreamReader(new FileInputStream(file));
                out = new OutputStreamWriter(new FileOutputStream("customer_sorted_by_score.txt"));

                int c;
                while ((c = in.read()) != -1){data.append((char) c);}

                String sortedData = sortData(data.toString());
                out.write(sortedData);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static String sortData(String data) {
        List<Customer> customers = new ArrayList<>();
        String[] dataFields = data.split(",|\\R");
        int len = dataFields.length;
        for (int i = 0; i <= len-3; i = i+3) {
            String name = dataFields[i];
            String phone = dataFields[i+1];
            int score = Integer.parseInt(dataFields[i+2]);
            Customer customer = new Customer(name,phone,score);
            customers.add(customer);

        }

        return customers.stream()
                .sorted(Comparator.comparing(Customer::getScore))
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

    }
}
