package com.epam.javatrainings.iohomework.task4;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomerIO io = new CustomerIO();
        File file = new File("customer_task_4.txt");
        try {
            io.write(new Customer("Sargis","+3749898565",3),file);
            Customer customer = io.read(file);
            System.out.println(customer.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
