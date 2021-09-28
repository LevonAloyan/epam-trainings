package com.epam.javatrainings.io.customers;

import java.io.*;
import java.util.Base64;

public class Serializer {
    private static final String SERIALIZATION_PATH = "resources/serialization/";

    private Serializer() {
        throw new IllegalStateException("No instances");
    }

    public static String serialize(Customer customer) {
        String serializedObjectFileName = customer.getName().replaceAll("\\s+","").toLowerCase()
                + "_" + System.currentTimeMillis();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(SERIALIZATION_PATH + serializedObjectFileName + ".txt"))) {

            // Encrypting the card number
            customer.setCardNumber(Base64.getEncoder().encodeToString(customer.getCardNumber().getBytes()));

            outputStream.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return serializedObjectFileName;
    }

    public static Customer deSerialize(String serializedObjectPath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(SERIALIZATION_PATH + serializedObjectPath + ".txt"))) {

            Customer customer = (Customer) objectInputStream.readObject();

            // Decrypting the card number
            customer.setCardNumber(new String(Base64.getDecoder().decode(customer.getCardNumber())));

            return customer;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
