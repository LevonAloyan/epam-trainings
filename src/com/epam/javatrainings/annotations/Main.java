package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.dto.CustomerDto;
import com.epam.javatrainings.annotations.validator.Validator;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        //test custom annotations
        CustomerDto customer = new CustomerDto();
        customer.setDiscountRate(10);
        customer.setName("sghghg");
        customer.setEmail("sjdh.hdh@sdgg");
        customer.setBirthday(LocalDate.now());
        Validator<CustomerDto> validator = new Validator<>();
        List<String> errorList = validator.validate(customer);
        if (errorList.size() > 0) {
            for (String s : errorList) {
                System.out.println(s);
            }
        }
    }
}
