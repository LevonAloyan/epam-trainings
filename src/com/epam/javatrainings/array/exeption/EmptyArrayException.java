package com.epam.javatrainings.array.exeption;



public class EmptyArrayException extends Exception{


    private static final String errorMassage = "The array is empty";

    public EmptyArrayException() {
        super(errorMassage);
    }
}
