package com.epam.javatrainings.input_output_task_homework.task2;

import com.epam.javatrainings.input_output_task_homework.task2.persistance.Customer;
import com.epam.javatrainings.input_output_task_homework.task2.processor.CSVProcessor;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Run program from terminal in this form -
 *               "javac Main.java"
 *               "java Main 'your file path'"
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String readFilePath = "";
        if (args.length > 0) {
            readFilePath = args[0];
        }

        List<Customer> customers = CSVProcessor.readCustomersInfoFromCsvFile(readFilePath);
        CSVProcessor.sortCustomersByScore(customers);
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("Please input file path for writing result");
        String filePath = scanner.nextLine();
        CSVProcessor.writeCustomerInfoInCsvFile(filePath, customers);
    }
}
