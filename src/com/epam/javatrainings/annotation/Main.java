package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.adulthood.AdulthoodAnnotationProcessor;
import com.epam.javatrainings.annotation.email.EmailAnnotationProcessor;
import com.epam.javatrainings.annotation.exception.IllegalAdultException;
import com.epam.javatrainings.annotation.exception.IllegalEmailException;
import com.epam.javatrainings.annotation.exception.IllegalLengthException;
import com.epam.javatrainings.annotation.exception.IllegalMinMaxValueException;
import com.epam.javatrainings.annotation.length.LengthAnnotationProcessor;
import com.epam.javatrainings.annotation.max.MaxAnnotationProcessor;
import com.epam.javatrainings.annotation.min.MinAnnotationProcessor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        CustomerDTO dto = new CustomerDTO("Anna", "aarakelyan1998@gmail.com",
                LocalDate.of(1998, 7, 24), 10);

        try {
            AdulthoodAnnotationProcessor.validateAge(dto);
            EmailAnnotationProcessor.validateEmail(dto);
            LengthAnnotationProcessor.validateLength(dto);
            MaxAnnotationProcessor.validateMaxValue(dto);
            MinAnnotationProcessor.validateMinValue(dto);

        } catch (
                IllegalAccessException
                        | IllegalEmailException
                        | IllegalAdultException
                        | IllegalLengthException
                        | IllegalMinMaxValueException exception) {

            exception.printStackTrace();
        } finally {
            System.out.println("Everything okay!");
        }
    }
}

