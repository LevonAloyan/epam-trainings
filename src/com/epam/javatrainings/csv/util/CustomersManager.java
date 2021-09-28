package com.epam.javatrainings.csv.util;

import com.epam.javatrainings.csv.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomersManager {

    private static final List<Customer> CUSTOMERS = new ArrayList<>();

    private CustomersManager() {

    }

    public static void initAndSortCustomersList(String filePath) {
        List<String> customersInLines = CsvReader.readAllCustomersFromCsv(filePath);
        for (String line : customersInLines) {
            List<String> fields = CsvReader.getFields(line);
            Customer customer = CustomerMapper.customerFromList(fields);
            CUSTOMERS.add(customer);
        }
        sortByScore(CUSTOMERS);
    }

    private static void sortByScore(List<Customer> customers) {
        Collections.sort(customers, new CustomerComparator());
    }

    private static class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return Integer.compare(o1.getScore(), o2.getScore());
        }
    }

    public static List<Customer> getCustomers() {
        return CUSTOMERS;
    }
}
