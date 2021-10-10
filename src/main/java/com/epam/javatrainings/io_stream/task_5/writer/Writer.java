package com.epam.javatrainings.io_stream.task_5.writer;

import com.epam.javatrainings.io_stream.task_5.model.Customer;

public interface Writer {
    void write(String path, Customer customer);
}
