package com.epam.javatrainings.serialization.task4;

import com.epam.javatrainings.serialization.task2.Customer;

import java.io.*;

public class Serialization {

    public static void main(String[] args) {
        Serialization serialization = new Serialization();
        Customer customer = new Customer("Anna", "+656682781809", 5);
        serialization.writeObject(customer, "cus.txt");

        System.out.println(serialization.readObject("cus.txt").toString());
    }

    public Customer readObject(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file))) {
            return (Customer) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeObject(Customer customer, String filePath) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))){
            outputStream.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
