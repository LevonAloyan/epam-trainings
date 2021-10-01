package com.epam.javatrainings.pizza;

import java.util.Random;

public class OrderNumberGeneratorImpl implements OrderNumberGenerator {
    @Override
    public int generate() {
        Random random = new Random();
        return 10000 + random.nextInt(89999);
    }
}

