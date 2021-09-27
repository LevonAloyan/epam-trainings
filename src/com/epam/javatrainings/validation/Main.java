package com.epam.javatrainings.validation;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        //invalid DTO test
        CustomerDto dto1 = new CustomerDto("p", "invalid#Email$@gmail.com",
                LocalDate.of(2014, 6, 18), -69);

        List<Error> errors1 = Validator.validate(dto1);
        ValidatorUtils.printErrorMessages(errors1);

        //valid DTO test
        CustomerDto dto2 = new CustomerDto("Neo", "agentSmith23@gmail.com",
                LocalDate.of(1999, 10, 23), 69);

        List<Error> errors2 = Validator.validate(dto2);
        ValidatorUtils.printErrorMessages(errors2);
    }
}
