package com.epam.javatrainings.IO.task_2;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        final String  filePath = "src/com/epam/javatrainings/IO/task_2/customer.csv";
        final String newFilepath = "src/com/epam/javatrainings/IO/task_2/sorted_customer.txt";

        FileReader f = new FileReader();
        TreeSet<com.epam.javatrainings.IO.task_2.Customer> customers = f.readFile(filePath);
        FileWriter w = new FileWriter();
        w.writeInFile(newFilepath, customers );
    }

}
