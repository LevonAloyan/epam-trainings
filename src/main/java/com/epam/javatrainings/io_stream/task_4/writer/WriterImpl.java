package com.epam.javatrainings.io_stream.task_4.writer;

import com.epam.javatrainings.io_stream.task_4.model.Customer;

import java.io.*;

public class WriterImpl implements Writer {
    @Override
    public void write(String path, Customer customer) {
        try( ObjectOutput obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
