package com.epam.javatrainings.io.CustomerSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil implements Serializable {

    public List<Customer> CSVReader(String fileName) {
        List<Customer> customers = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String newLine = bufferedReader.readLine();
                if(newLine != null) {
                    do {
                        String[] customerData = newLine.split(", ");
                        Customer newCustomer = new Customer(customerData[0], customerData[1], Integer.parseInt(customerData[2]), null);
                        customers.add(newCustomer);
                        newLine = bufferedReader.readLine();
                    } while (newLine != null);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        return customers;
    }

    public void CSVWriter(List<Customer> customers, String outputName) {
        customers.sort(new CustomerScoreComparator());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputName))) {
            for (Customer customer : customers) {
                bufferedWriter.write(customer.getName() + ", " +
                                         customer.getPhone() + ", " +
                                         customer.getScore());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
