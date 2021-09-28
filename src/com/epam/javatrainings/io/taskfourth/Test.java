package com.epam.javatrainings.io.taskfourth;

import com.epam.javatrainings.io.tasktwo.Customer;

public class Test {

  private static final String FILE_NAME = "serialized.txt";
  private static final String CUSTOMER_NAME = "Artashes";
  private static final String CUSTOMER_PHONE_NUMBER = "+ 374 041000001";
  private static final int CUSTOMER_SCORE = 10;

  public static void main(String[] args) {

    Customer customer = new Customer(CUSTOMER_NAME, CUSTOMER_PHONE_NUMBER, CUSTOMER_SCORE);
    SerializationCustomer.serializedCustomer(customer, FILE_NAME);

    Customer deSerializedCustomer = SerializationCustomer.deSerializedCustomer(FILE_NAME);
    System.out.println(deSerializedCustomer);
  }
}
