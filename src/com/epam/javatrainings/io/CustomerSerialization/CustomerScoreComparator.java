package com.epam.javatrainings.io.CustomerSerialization;

import java.util.Comparator;

public class CustomerScoreComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o1.getScore(), o2.getScore());
    }
}
