package com.epam.javatrainings.io.taskfifth;

import com.epam.javatrainings.io.tasktwo.Customer;

public class Test {

  private static final String FILE_NAME = "encrypt.txt";
  private static final String CUSTOMER_NAME = "Artashes";
  private static final String CUSTOMER_PHONE_NUMBER = "+ 374 041000001";
  private static final int CUSTOMER_SCORE = 10;
  private static final String CUSTOMER_CARD_NUMBER = "12345678910";

  public static void main(String[] args) {

    Customer customer = new Customer(CUSTOMER_NAME, CUSTOMER_PHONE_NUMBER, CUSTOMER_SCORE);

    customer.setCardNumber(CUSTOMER_CARD_NUMBER);
    EncryptDecryptCustomer.serializedEncryptCustomer(customer, FILE_NAME);

    Customer deSerializedCustomer = EncryptDecryptCustomer.deSerializedDecryptCustomer(FILE_NAME);
    System.out.println(deSerializedCustomer);
  }
}
