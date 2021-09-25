package com.epam.javatrainings.annotations;


import com.epam.javatrainings.annotations.exception.EmailNotValidException;
import com.epam.javatrainings.annotations.exception.InappropriateAgeException;
import com.epam.javatrainings.annotations.exception.InappropriateNameException;
import com.epam.javatrainings.annotations.exception.WrongDiscountException;

import java.time.LocalDate;

public class CustomerDtoDemo {
    public static void main(String[] args) throws NoSuchFieldException, InappropriateNameException, WrongDiscountException,
            EmailNotValidException, InappropriateAgeException, IllegalAccessException {


        //will be validate without errors :)
        CustomerDto customerDto = new CustomerDto("Anna", "anya.qaramyan00@gmail.ru", LocalDate.of(2000, 7, 12), 30);
      //  Validation.validate(customerDto);

        //Here is Email not Valid Exception
        CustomerDto customerDto1 = new CustomerDto("Anna", "56567ru", LocalDate.of(2000, 7, 12), 30);
       // Validation.validate(customerDto1);

        // Here is Inappropriate Name Exception
        CustomerDto customerDto2 = new CustomerDto("m", "anya.qaramyan00@gmail.ru", LocalDate.of(2000, 7, 12), 30);
      //  Validation.validate(customerDto2);

        //Here is Inappropriate age
        CustomerDto customerDt3 = new CustomerDto("Anna", "anya.qaramyan00@gmail.ru", LocalDate.of(2022, 7, 12), 30);
      //  Validation.validate(customerDt3);


        //here is wrong discount Exception
        CustomerDto customerDto4 = new CustomerDto("Anna", "anya.qaramyan00@gmail.ru", LocalDate.of(2000, 7, 12), 9);
       // Validation.validate(customerDto4);
    }
}