package com.epam.javatrainings.input_output_task_homework.task2.processor;

import com.epam.javatrainings.input_output_task_homework.task2.persistance.Customer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVProcessor {
    public static List<Customer> readCustomersInfoFromCsvFile(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<Customer> customers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerInfos = line.split(",");
                customers.add(new Customer(customerInfos[0].trim(), customerInfos[1].trim(), Integer.parseInt(customerInfos[2].trim())));
            }
            return customers;
        }
    }

    public static void sortCustomersByScore(List<Customer> customers) {
        Collections.sort(customers);
    }

    public static void writeCustomerInfoInCsvFile(String filePath, List<Customer> customers) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(filePath));
            for (Customer customer : customers) {
                bufferedWriter.write(customer.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
