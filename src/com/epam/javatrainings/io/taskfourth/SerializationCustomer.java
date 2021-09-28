package com.epam.javatrainings.io.taskfourth;

import com.epam.javatrainings.io.tasktwo.Customer;
import java.io.*;

public class SerializationCustomer {

  public static void serializedCustomer(Customer customer, String fileName) {

    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new FileOutputStream(fileName))) {
      objectOutputStream.writeObject(customer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Customer deSerializedCustomer(String fileName) {

    Customer customer = null;
    try (ObjectInputStream objectInputStream =
        new ObjectInputStream(new FileInputStream(fileName))) {
      customer = (Customer) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return customer;
  }
}
