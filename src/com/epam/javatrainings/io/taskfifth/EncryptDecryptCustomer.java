package com.epam.javatrainings.io.taskfifth;

import com.epam.javatrainings.io.tasktwo.Customer;

import java.io.*;
import java.util.Base64;

public class EncryptDecryptCustomer {

  public static void serializedEncryptCustomer(Customer customer, String fileName) {

    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new FileOutputStream(fileName))) {
      String encryptCardNumber =
          Base64.getEncoder().encodeToString(customer.getCardNumber().getBytes());
      customer.setCardNumber(encryptCardNumber);
      objectOutputStream.writeObject(customer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Customer deSerializedDecryptCustomer(String fileName) {

    Customer customer = null;
    try (ObjectInputStream objectInputStream =
        new ObjectInputStream(new FileInputStream(fileName))) {

      customer = (Customer) objectInputStream.readObject();
      byte[] decodeCardNumber = (Base64.getDecoder().decode(customer.getCardNumber()));
      String temp = new String(decodeCardNumber);
      customer.setCardNumber(temp);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return customer;
  }
}
