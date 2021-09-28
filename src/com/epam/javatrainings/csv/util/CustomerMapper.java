package com.epam.javatrainings.csv.util;

import com.epam.javatrainings.csv.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    private CustomerMapper() {

    }

    public static Customer customerFromList(List<String> objectFields) {
        String name = objectFields.get(0);
        String tel = objectFields.get(1);
        int score = Integer.parseInt(objectFields.get(2));

        return new Customer(name, tel, score);
    }

    public static List<String> customerAsList(Customer customer) {
        List<String> fields = new ArrayList<>();
        fields.add(customer.getName());
        fields.add(customer.getTel());
        fields.add(String.valueOf(customer.getScore()));

        return fields;
    }
}
