package com.epam.javatrainings.io_stream.task_2.reader;

import com.epam.javatrainings.io_stream.task_2.model.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<Customer> readData(String path) {
        BufferedReader reader;
        BufferedWriter writer;
        List<Customer> customerList = new ArrayList<>();
        String row;
        try {
            reader = new BufferedReader(new FileReader(path));

            while ((row = reader.readLine()) != null) {
                String[] rows = row.split(",");

                customerList.add(new Customer(rows[0], rows[1], Integer.parseInt(rows[2])));

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
