package com.epam.javatrainings.io_stream.task_2.writer;

import com.epam.javatrainings.io_stream.task_2.model.Customer;

import java.io.*;
import java.util.List;

public class WriterImpl implements Writer {
    private final String path;

    public WriterImpl(String path) {
        this.path = path;
    }

    @Override
    public void writeData(List<Customer> customerList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (Customer customer : customerList) {

                writer.write(customer.getName()
                        + "," + customer.getPhone()
                        + "," + customer.getScore() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
