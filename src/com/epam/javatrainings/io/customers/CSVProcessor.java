package com.epam.javatrainings.io.customers;

import java.io.*;
import java.util.ArrayList;

public class CSVProcessor {
    private CSVProcessor() {
        throw new IllegalStateException("No instances");
    }

    public static ArrayList<Customer> csvToCustomers(String filePath) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try (BufferedReader csvReader =  new BufferedReader(new FileReader(filePath))) {
            String csvRow;

            while ((csvRow = csvReader.readLine()) != null) {
                String[] data = csvRow.split(",");
                customers.add(new Customer(data[0], data[1], Integer.valueOf(data[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    return customers;
    }

    public static void customersToCsv(ArrayList<Customer> customers, String filePath) {
        try (BufferedWriter csvWriter =  new BufferedWriter(
                new FileWriter(filePath.split("\\.csv")[0] + "_sorted.csv"))) {
            for (Customer customer : customers) {
                csvWriter.write(customer.getName() + "," + customer.getPhone() + "," + customer.getScore() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
