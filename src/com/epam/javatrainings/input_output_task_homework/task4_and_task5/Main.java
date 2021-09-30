package com.epam.javatrainings.input_output_task_homework.task4_and_task5;

import com.epam.javatrainings.input_output_task_homework.task2.persistance.Customer;
import com.epam.javatrainings.input_output_task_homework.task4_and_task5.processor.Serializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Khikar","+ 374 77 33 55 28",11,"4083060010626808");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input file path");
        String filePath = scanner.nextLine();
        Serializer.serialize(customer,filePath);
        System.out.println(Serializer.deserialize(filePath));
    }
}
