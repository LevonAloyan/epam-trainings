package com.epam.javatrainings.io.tasktwo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class CSVUtil {
  public static List<Customer> readCustomersFromCSV(String fileName) {

    List<Customer> customers = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);

    try (BufferedReader bufferedReader = newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
      String line = bufferedReader.readLine();

      while (line != null) {
        String[] attributes = line.split(",");
        Customer customer = createCustomer(attributes);
        customers.add(customer);
        line = bufferedReader.readLine();
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    return customers;
  }

  private static Customer createCustomer(String[] metadata) {
    String name = metadata[0].trim();
    String phone = metadata[1].trim();
    int score = Integer.parseInt(metadata[2].trim());
    return new Customer(name, phone, score);
  }

  public static void writeCustomersToCVS(List<Customer> customers, String fileName) {
    try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName))) {
      for (Customer customer : customers) {
        bufferedWriter.write(String.valueOf(customer));
        bufferedWriter.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
