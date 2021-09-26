package com.epam.javatrainings.annootation_based_DTO;

import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;
import com.epam.javatrainings.annootation_based_DTO.service.*;

public class Main {
    public static void main(String[] args){
        CustomerDto customerDto = CustomerDtoService.createCustomer();
        try {
            ValidatorService.printAllExceptions(customerDto);
        } catch (NoSuchFieldException | IllegalAccessException | NullPointerException e){
            e.printStackTrace();
        }
    }
}
