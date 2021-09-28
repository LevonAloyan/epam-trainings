package com.epam.javatrainings.csv.util;

import com.epam.javatrainings.csv.model.Customer;

import java.io.*;
import java.util.List;

public class CsvWriter {

    private CsvWriter() {

    }

    public static void writeCustomerToCsv(List<String> objectFields, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(objectFields.get(0) + ",");
            bufferedWriter.write(objectFields.get(1) + ",");
            bufferedWriter.write(objectFields.get(2) + "\n");
        } catch (IOException e) {
            System.out.println("Can't read from file");
        } finally {
            try {
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Cant close Buffered writer");
            }
        }
    }

    public static void writeSortedCustomersToNewCsv(String filePath, String newFilePath) {
        CustomersManager.initAndSortCustomersList(filePath);
        List<Customer> customers = CustomersManager.getCustomers();
        for (Customer customer : customers) {
            List<String> fields = CustomerMapper.customerAsList(customer);
            CsvWriter.writeCustomerToCsv(fields, newFilePath);
        }
    }
}
