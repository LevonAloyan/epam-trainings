package com.epam.javatrainings.array;



public class EmptyArrayException extends Exception{


    private static final String errorMassage = "The array must noy be empty";

    public EmptyArrayException() {
        super(errorMassage);
    }
}
