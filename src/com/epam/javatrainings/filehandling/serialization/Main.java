package com.epam.javatrainings.filehandling.serialization;

import com.epam.javatrainings.filehandling.csv.Customer;
import com.epam.javatrainings.filehandling.downloadhtml.FileManipulationException;

import java.io.*;

public class Main {

  public static final String FILE_PATH =
      "epam-trainings/src/com/epam/javatrainings/filehandling/serialization/customer.ser";

  public static void main(String[] args) {
    Customer customer = new Customer("Artashes", "+ 374 041000001", 10, "0123999911116789");
    ObjectInputStream ois;
    ObjectOutputStream oos;
    try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
        FileInputStream fis = new FileInputStream(FILE_PATH)) {
      oos = new ObjectOutputStream(fos);
      oos.writeObject(customer);

      ois = new ObjectInputStream(fis);
      Customer customerDeserialized = (Customer) ois.readObject();
      System.out.println("Customer after deserialization : " + customerDeserialized);
    } catch (ClassNotFoundException | IOException e) {
      throw new FileManipulationException(
          "Failed while serializing/deserializing customer", e.getCause());
    }
  }
}
