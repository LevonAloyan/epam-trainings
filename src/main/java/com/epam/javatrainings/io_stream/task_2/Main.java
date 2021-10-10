package com.epam.javatrainings.io_stream.task_2;

import com.epam.javatrainings.io_stream.task_2.model.Customer;
import com.epam.javatrainings.io_stream.task_2.reader.Reader;
import com.epam.javatrainings.io_stream.task_2.reader.ReaderImpl;
import com.epam.javatrainings.io_stream.task_2.writer.Writer;
import com.epam.javatrainings.io_stream.task_2.writer.WriterImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static final String PATH = "task_2_files/write.csv";
    public static final String PATH1 = "task_2_files/read.csv";

    public static void main(String[] args) {

        List<Customer> list = new ArrayList<>();

        list.add(new Customer("Anna", "+37477307953", 15));
        list.add(new Customer("Arman", "+37494802028", 2));
        list.add(new Customer("Artur", "+37493900032", 1));
        list.add(new Customer("Vard", "+37477246800", 5));

        Reader reader = new ReaderImpl();
        reader.readData(PATH);
        Writer writer = new WriterImpl(PATH1);
        writer.writeData(list);

        Collections.sort(list);

        Writer writer1 = new WriterImpl(PATH);
        writer1.writeData(list);

    }
}
