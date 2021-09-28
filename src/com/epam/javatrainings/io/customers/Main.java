package com.epam.javatrainings.io.customers;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // For csv read/write stuff (Task 2)
        // From the terminal run the following command:
        // java mainClass fullPathToCSVResource

        // runCsvProcessorApp(args[0]);

        /* For serialization stuff */
        Customer customer = new Customer("Ara Gasparyan", "+ 000 123456", 25,
                "1234-2345-3456-4567");
        String serializedObjectPath = Serializer.serialize(customer);

        Customer deSerializedCustomer = Serializer.deSerialize(serializedObjectPath);
        System.out.println(deSerializedCustomer);
    }


    static void runCsvProcessorApp(String filePath) {
        // Read csv into List
        ArrayList<Customer> customers = CSVProcessor.csvToCustomers(filePath);

        // Sort customers by defined natural order
        Collections.sort(customers);

        // Generate csv from Customer object's list
        CSVProcessor.customersToCsv(customers, filePath);
    }
}
