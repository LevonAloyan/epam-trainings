package com.epam.javatrainings.classdecomposition.service;

import com.epam.javatrainings.classdecomposition.persistance.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public static Customer createCustomer(String name, double money){
        return new Customer(name,money);
    }

    public static List<Customer> storedPizzeriaCustomers(Customer customer){
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        return customers;
    }
}
