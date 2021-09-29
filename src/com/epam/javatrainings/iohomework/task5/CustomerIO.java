package com.epam.javatrainings.iohomework.task5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class CustomerIO {


    public void write(Customer customer, File file) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            String encodedCardNumber = Base64.getEncoder().encodeToString(customer.getCardNumber().getBytes(StandardCharsets.UTF_8));
            customer.setCardNumber(encodedCardNumber);
            out.writeObject(customer);
        }

    }

    public Customer read(File file) throws IOException,ClassNotFoundException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Customer customer = (Customer) in.readObject();
            String decodedCardNumber = new String(
                    Base64.getDecoder().decode(customer.getCardNumber())
            );
            customer.setCardNumber(decodedCardNumber);
            return customer;
        }

    }
}
