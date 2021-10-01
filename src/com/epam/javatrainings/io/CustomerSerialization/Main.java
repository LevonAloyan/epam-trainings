package com.epam.javatrainings.io.CustomerSerialization;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CSVUtil csvUtil = new CSVUtil();
        List<Customer> customers = csvUtil.CSVReader("customers.csv");
        csvUtil.CSVWriter(customers, "SortedCustomers.csv");

        Customer customer = new Customer("Emin", "+ 374 33557799", 23, "2878 0047 9166 1726");
        CustomerSerializer.serialize(customer, "testCustomer.txt");

        Customer deserializedCustomer = CustomerSerializer.deserialize("testCustomer.txt");
        System.out.println(deserializedCustomer);

    }
}
