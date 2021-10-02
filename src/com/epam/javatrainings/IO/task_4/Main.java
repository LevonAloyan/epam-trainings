package com.epam.javatrainings.IO.task_4;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FileSerializer f= new FileSerializer();
        Customer customer = new Customer("Tatev", "+ 374 041000001", 10);
        Customer customer1 = new Customer("Lilit", "+ 8665 6656", 15);
        String  filePath = "src/com/epam/javatrainings/IO/task_4/customer_data.txt";

        HashSet<Customer> hashSet = new HashSet<>();
        hashSet.add(customer);
        hashSet.add(customer1);
        f.serializeCustomer(filePath, hashSet);

        HashSet<Customer> customerHashSet =(HashSet<Customer>) f.deserialzeCustomer(filePath);
        for (Customer value : customerHashSet) System.out.println(value);
    }
}
