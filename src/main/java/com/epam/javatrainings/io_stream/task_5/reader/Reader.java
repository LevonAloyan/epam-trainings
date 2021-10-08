package com.epam.javatrainings.io_stream.task_5.reader;

import com.epam.javatrainings.io_stream.task_5.model.Customer;

public interface Reader {
    Customer read(String path);
}
