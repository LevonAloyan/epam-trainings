package com.epam.javatrainings.filehandling.csv;

import java.util.Base64;
import java.io.Serializable;

public final class Customer implements Serializable {
  private final String name;
  private final transient String phoneNumber;
  private final int score;
  private final String cardNumber;

  public Customer(String name, String phoneNumber, int score, String cardNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.score = score;
    this.cardNumber = String.valueOf(Base64.getEncoder().encodeToString(cardNumber.getBytes()));
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getScore() {
    return score;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  @Override
  public String toString() {
    return "Customer{"
        + "name='"
        + name
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", score="
        + score
        + ", cardNumber='"
        + new String(Base64.getDecoder().decode(cardNumber.getBytes()))
        + '\''
        + '}';
  }
}
