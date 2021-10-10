package com.epam.javatrainings.io_stream.task_4.reader;

import com.epam.javatrainings.io_stream.task_4.model.Customer;

import java.io.*;

public class ReaderImpl implements Reader {
    Customer customer;

    @Override
    public Customer read(String path) {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {

            customer = (Customer) obj.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
