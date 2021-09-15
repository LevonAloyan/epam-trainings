package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.exceptions.InvalidLengthException;
import com.epam.javatrainings.annotations.exceptions.InvalidNumberException;
import com.epam.javatrainings.annotations.forAdulthood.AdulthoodProcessor;
import com.epam.javatrainings.annotations.exceptions.NotAdulthoodException;
import com.epam.javatrainings.annotations.forDiscountMinMax.MaxProcessor;
import com.epam.javatrainings.annotations.forDiscountMinMax.MinProcessor;
import com.epam.javatrainings.annotations.forEmail.EmailProcessor;
import com.epam.javatrainings.annotations.exceptions.InvalidEmailException;
import com.epam.javatrainings.annotations.forLength.LengthProcessor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class TestAnnotations {

    public static void main(String[] args) throws InvalidLengthException, IOException, ClassNotFoundException,
            InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvalidEmailException, NotAdulthoodException, InvalidNumberException {

        String myPackage = "com.epam.javatrainings.annotations";

        System.out.println("Test @Length annotation");
        LengthProcessor lengthProcessor = new LengthProcessor();
        lengthProcessor.doProcess(myPackage, "Erik"); //it's ok!
//        lengthProcessor.doProcess(myPackage, "E"); //it's bad!

        System.out.println("Test @Email annotation");
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.doProcess(myPackage, "erickmargarian@gmail.com"); //it's ok!
//        emailProcessor.doProcess(myPackage, "erickmargarian@"); //it's bad!

        System.out.println("Test @Adulthood annotation");
        AdulthoodProcessor adulthoodProcessor = new AdulthoodProcessor();
        adulthoodProcessor.doProcess(myPackage, LocalDate.of(1999, 12, 22)); //it's ok!
//        adulthoodProcessor.doProcess(myPackage, LocalDate.of(2021, 12, 22)); //it's bad!

        System.out.println("Test @Min annotation");
        MinProcessor minProcessor = new MinProcessor();
        minProcessor.doProcess(myPackage, 20); //it's ok!
//        minProcessor.doProcess(myPackage, 5); //it's bad!


        System.out.println("Test @Max annotation");
        MaxProcessor maxProcessor = new MaxProcessor();
        maxProcessor.doProcess("com.epam.javatrainings.annotations", 50); //it's ok!
//        maxProcessor.doProcess("com.epam.javatrainings.annotations", 200); //it's bad!
    }
}
