package com.epam.javatrainings.pizza;

import java.util.Random;

public class OrderNumber {
    Random random = new Random();

    public int getNumber() {
        return number;
    }

    private final int number = 10000 + random.nextInt(89999);
}
