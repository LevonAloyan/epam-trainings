package com.epam.javatrainings.io_stream.task_2.reader;

import com.epam.javatrainings.io_stream.task_2.model.Customer;

import java.util.List;

public interface Reader {
    List<Customer> readData(String path);
}
