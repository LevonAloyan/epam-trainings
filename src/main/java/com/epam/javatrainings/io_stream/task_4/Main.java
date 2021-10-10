package com.epam.javatrainings.io_stream.task_4;

import com.epam.javatrainings.io_stream.task_4.model.Customer;
import com.epam.javatrainings.io_stream.task_4.reader.Reader;
import com.epam.javatrainings.io_stream.task_4.reader.ReaderImpl;
import com.epam.javatrainings.io_stream.task_4.writer.Writer;
import com.epam.javatrainings.io_stream.task_4.writer.WriterImpl;

public class Main {
    public static final String PATH = "task_4_files/test.txt";

    public static void main(String[] args) {
        Customer customer = new Customer("Anna", "077307953", 1);

        Writer writer = new WriterImpl();
        writer.write(PATH, customer);

        Reader reader = new ReaderImpl();
        Customer customer1 = reader.read(PATH);

        System.out.println(customer1);
    }
}
