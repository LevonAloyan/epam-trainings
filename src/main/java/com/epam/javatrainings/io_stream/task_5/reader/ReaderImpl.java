package com.epam.javatrainings.io_stream.task_5.reader;

import com.epam.javatrainings.io_stream.task_5.model.Customer;

import java.io.*;
import java.util.Base64;

public class ReaderImpl implements Reader {
    Customer customer;

    @Override
    public Customer read(String path) {
        try (ObjectInput obj = new ObjectInputStream(new FileInputStream(path))) {
            customer = (Customer) obj.readObject();
            String decoder = new String(Base64.getDecoder().decode(customer.getCardNumber()));

            customer.setCardNumber(decoder);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
