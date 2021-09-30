package com.epam.javatrainings.filehandling.csv;

public class Customer {
  private final String name;
  private final String phoneNumber;
  private final int score;

  public Customer(String name, String phoneNumber, int score) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.score = score;
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
}
