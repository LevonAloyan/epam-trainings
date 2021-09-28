package com.epam.javatrainings.io.tasktwo;

import java.io.Serializable;

public class Customer implements Comparable<Customer>, Serializable {
  private static final long serialVersionUID = 1L;
  private final String name;
  private final transient String phone;
  private final int score;
  private String cardNumber;

  public Customer(String name, String phone, int score) {
    this.name = name;
    this.phone = phone;
    this.score = score;
  }
  public int getScore() {
    return score;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  @Override
  public String toString() {
    return name + ", " + phone + ", " + score + ", "+ cardNumber;
  }

  @Override
  public int compareTo(Customer o) {
    return Integer.compare(getScore(), o.getScore());
  }
}
