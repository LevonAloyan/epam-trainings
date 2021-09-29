package com.epam.javatrainings.serialization.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerFile {


    public static void main(String[] args) {
        CustomerComparator customerComparator = new CustomerComparator();
        CustomerFile customerFile = new CustomerFile();
        List<Customer> list = new ArrayList<>();
        list = customerFile.readObj(args[0]);
        list.sort(customerComparator);
        System.out.println(list);

        for (Customer customer : list) {
            customerFile.writeObject(customer, "C:\\Users\\admin\\IdeaProjects\\homeworkOfClasses\\epam-trainings\\Customers.txt");
        }

    }

    public List<Customer> readObj(String file) {
        List<Customer> myObjs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String currentObj[] = line.split(",");
                Customer customer = new Customer(currentObj[0], currentObj[1], Integer.valueOf(currentObj[2].trim()));
                myObjs.add(customer);
            }
        } catch (IOException e) {
            System.out.println("something is wrong");
        }
        return myObjs;
    }

    public void writeObject(Customer customer, String filePath) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {

            outputStream.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
