package com.epam.javatrainings.io_stream.task_4.reader;

import com.epam.javatrainings.io_stream.task_4.model.Customer;

public interface Reader {
    Customer read(String path);
}
