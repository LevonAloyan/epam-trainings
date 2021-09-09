package com.epam.javatrainings;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        LocalDate ld = LocalDate.of(2005,3,28);
        CustomerDto cs = new CustomerDto("D", "@gmail.com", ld, 137);
        Validator v = new Validator(cs);
        ArrayList<Error> ls = v.Validate();

        for (Error er : ls){
            System.out.println(er.getDescription());
        }

    }
}
