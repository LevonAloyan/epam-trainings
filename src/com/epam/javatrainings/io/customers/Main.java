package com.epam.javatrainings.io.customers;

import java.util.ArrayList;
import java.util.Collections;

// From the terminal run
// java mainClass fullPathToResource
public class Main {
    public static void main(String[] args) {
        // Read csv into List
        ArrayList<Customer> customers = CSVProcessor.csvToCustomers(args[0]);

        // Sort customers by defined natural order
        Collections.sort(customers);

        // Generate csv from Customer object's list
        CSVProcessor.customersToCsv(customers, args[0]);
    }
}
