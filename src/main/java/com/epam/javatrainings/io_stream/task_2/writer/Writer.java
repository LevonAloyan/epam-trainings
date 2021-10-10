package com.epam.javatrainings.io_stream.task_2.writer;

import com.epam.javatrainings.io_stream.task_2.model.Customer;

import java.util.List;

public interface Writer {
    void writeData(List<Customer> customerList);
}
