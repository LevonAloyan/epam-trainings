package com.epam.javatrainings.iohomework.task5;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CustomerIO io = new CustomerIO();
        File file = new File("customer_task_5.txt");
        try {
            io.write(new Customer("Sargis","+3749898565",3,"ABC12378dc"),file);
            Customer customer = io.read(file);
            System.out.println(customer.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
