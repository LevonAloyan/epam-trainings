package com.epam.javatrainings.io.tasktwo;

import java.util.Collections;
import java.util.List;

public class Test {

  private static final String ORIGINAL_FILE_NAME = "customer.csv";
  private static final String SORTED_FILE_NAME = "customersorted.csv";

  public static void main(String[] args) {

    List<Customer> customers = CSVUtil.readCustomersFromCSV(ORIGINAL_FILE_NAME);
    Collections.sort(customers);
    CSVUtil.writeCustomersToCVS(customers, SORTED_FILE_NAME);
  }
}
