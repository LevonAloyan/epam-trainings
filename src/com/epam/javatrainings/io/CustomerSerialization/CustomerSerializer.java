package com.epam.javatrainings.io.CustomerSerialization;

import java.io.*;
import java.util.Base64;

public class CustomerSerializer {

    public static Customer deserialize(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            Customer customer = (Customer) objectInputStream.readObject();
            String cardNumber = customer.getCardNumber();
            byte[] decodedCardNumber = Base64.getDecoder().decode(cardNumber);
            customer.setCardNumber(new String(decodedCardNumber));
            return customer;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serialize(Customer customer, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            String cardNumber = customer.getCardNumber();
            String encodedCardNumber = Base64.getEncoder().encodeToString(cardNumber.getBytes());
            customer.setCardNumber(encodedCardNumber);
            outputStream.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
