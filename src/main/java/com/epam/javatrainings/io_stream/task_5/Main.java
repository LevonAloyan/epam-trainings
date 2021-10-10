package com.epam.javatrainings.io_stream.task_5;

import com.epam.javatrainings.io_stream.task_5.reader.Reader;
import com.epam.javatrainings.io_stream.task_5.reader.ReaderImpl;
import com.epam.javatrainings.io_stream.task_5.model.Customer;
import com.epam.javatrainings.io_stream.task_5.writer.Writer;
import com.epam.javatrainings.io_stream.task_5.writer.WriterImpl;

public class Main {
    public static final String PATH = "task_5_files/test.txt";

    public static void main(String[] args) {
        Customer customer = new Customer("Arman", "094802028",
                5, "1253 8475 1236 5487");

        Writer writer = new WriterImpl();
        writer.write(PATH,customer);

        Reader reader = new ReaderImpl();
        Customer customer1 = reader.read(PATH);

        System.out.println(customer1);
    }
}
