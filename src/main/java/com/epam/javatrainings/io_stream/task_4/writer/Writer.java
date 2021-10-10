package com.epam.javatrainings.io_stream.task_4.writer;

import com.epam.javatrainings.io_stream.task_4.model.Customer;

public interface Writer {
    void write(String path, Customer customer);
}
