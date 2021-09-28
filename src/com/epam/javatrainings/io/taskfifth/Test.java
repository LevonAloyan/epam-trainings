package com.epam.javatrainings.io.taskfifth;

import com.epam.javatrainings.io.tasktwo.Customer;

public class Test {

  public static final String FILE_NAME = "encrypt.txt";
  public static final String CUSTOMER_NAME = "Artashes";
  public static final String CUSTOMER_PHONE_NUMBER = "+ 374 041000001";
  public static final int CUSTOMER_SCORE = 10;
  public static final String CUSTOMER_CARD_NUMBER = "12345678910";

  public static void main(String[] args) {

    Customer customer = new Customer(CUSTOMER_NAME, CUSTOMER_PHONE_NUMBER, CUSTOMER_SCORE);

    customer.setCardNumber(CUSTOMER_CARD_NUMBER);
    EncryptDecryptCustomer.serializedEncryptCustomer(customer, FILE_NAME);

    Customer deSerializedCustomer = EncryptDecryptCustomer.deSerializedDecryptCustomer(FILE_NAME);
    System.out.println(deSerializedCustomer);
  }
}
