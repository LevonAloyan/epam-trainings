package com.epam.javatrainings.annotations;


import com.epam.javatrainings.annotations.exception.EmailNotValidException;
import com.epam.javatrainings.annotations.exception.InappropriateAgeException;
import com.epam.javatrainings.annotations.exception.InappropriateNameException;
import com.epam.javatrainings.annotations.exception.WrongDiscountException;

import java.time.LocalDate;

public class CustomerDtoDemo {
    public static void main(String[] args) throws NoSuchFieldException, InappropriateNameException, WrongDiscountException, EmailNotValidException, InappropriateAgeException, IllegalAccessException {
        CustomerDto customerDto = new CustomerDto("Anna", "anya.qaramyan00@gmail.ru", LocalDate.of(2000, 7, 12), 30);
         Validation.validate(customerDto);
    }
}