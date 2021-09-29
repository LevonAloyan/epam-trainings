package com.epam.javatrainings.homework_7.Task2;

import java.util.List;


public class Main {
    public static void main(String [] args){
        List<Customer> customers = FileOperations.getData(args[0]);
        customers.forEach(c -> System.out.println(c));
        FileOperations.saveData(args[0],customers);
    }
}

