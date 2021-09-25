package com.epam.javatrainings.timer.counter;

public abstract class Counter implements Runnable {
  private int value;

  protected Counter(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  protected String obtainFormattedValueThenDecrement(String prefix, String suffix) {
    return prefix + (value < 10 ? "0" : "") + value-- + suffix;
  }

  protected String obtainFormattedValueThenDecrement() {
    return obtainFormattedValueThenDecrement("\b\b", "");
  }
}
