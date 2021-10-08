package com.epam.javatrainings.io_stream.task_5.writer;

import com.epam.javatrainings.io_stream.task_5.model.Customer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WriterImpl implements Writer {
    @Override
    public void write(String path, Customer customer) {
        try (ObjectOutput obj = new ObjectOutputStream(new FileOutputStream(path))) {
            String encoder = Base64.getEncoder()
                    .encodeToString(customer.getCardNumber()
                            .getBytes(StandardCharsets.UTF_8));

            customer.setCardNumber(encoder);

            obj.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
