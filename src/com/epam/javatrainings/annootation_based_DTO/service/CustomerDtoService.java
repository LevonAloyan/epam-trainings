package com.epam.javatrainings.annootation_based_DTO.service;

import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerDtoService {
    public static CustomerDto createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input customer name: Customer " +
                "name length could not be \"less than 2 and more " +
                "than 30 characters\"");
        String customerName = scanner.next();
        System.out.println("Please input customer email: Customer " +
                "email should be in this form \"somethingText@gmail" +
                " or mail.com or ru\"");
        String customerEmail = scanner.next();
        System.out.println("Please input customer birth year");
        int birthYear = scanner.nextInt();
        System.out.println("Please input customer birth month in numbers");
        int birthMonth = scanner.nextInt();
        System.out.println("Please input customer birth day");
        int birthDay = scanner.nextInt();
        LocalDate customerBirthDay = LocalDate.of(birthYear, birthMonth, birthDay);
        System.out.println("Please input customer discount rate: Customer " +
                "discount rate could not be \"less than 0 and more than " +
                "100 characters\" ");
        int discountRate = scanner.nextInt();

        return new CustomerDto(customerName, customerEmail, customerBirthDay, discountRate);
    }
}
