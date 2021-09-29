package com.epam.javatrainings.serialization.task5;

import com.epam.javatrainings.serialization.task2.Customer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodedSerialization {
    public static void main(String[] args) {
        EncodedSerialization encodedSerialization = new EncodedSerialization();
        Customer customer = new Customer("Anna", "2874874289191", 4);
        customer.setCardNumber("25646325");
        encodedSerialization.writeObject(customer, "C:\\Users\\admin\\IdeaProjects\\homeworkOfClasses\\epam-trainings\\ex1.txt");
        System.out.println(customer.getCardNumber());
        customer = encodedSerialization.readObject("C:\\Users\\admin\\IdeaProjects\\homeworkOfClasses\\epam-trainings\\ex1.txt");
        System.out.println(customer.getCardNumber());
    }

    public Customer readObject(String file) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file))) {
            Customer customer = (Customer) objectInputStream.readObject();

            byte[] decodedBytes = Base64.getDecoder().decode(customer.getCardNumber());
            String decodedString = new String(decodedBytes);
            customer.setCardNumber(decodedString);
            return customer;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeObject(Customer customer, String filePath) {

        String originalInput = customer.getCardNumber();
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes(StandardCharsets.UTF_8));

        customer.setCardNumber(encodedString);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            outputStream.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
