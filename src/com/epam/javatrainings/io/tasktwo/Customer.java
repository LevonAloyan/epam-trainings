package com.epam.javatrainings.io.tasktwo;

public class Customer implements Comparable<Customer> {
  private final String name;
  private final String phone;
  private final int score;

  public Customer(String name, String phone, int score) {
    this.name = name;
    this.phone = phone;
    this.score = score;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return name + ", " + phone + ", " + score;
  }

  @Override
  public int compareTo(Customer o) {
    return Integer.compare(getScore(), o.getScore());
  }
}
