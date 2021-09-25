package com.epam.javatrainings.multiThread;

public class Validation {

    public static boolean isValid(int minute, int second){
        if (minute < 0) {
            throw new RuntimeException("Minute can't be negative");
        }
        if (second < 0 || second > 59) {
            throw new RuntimeException("Second must be between 0 and 60");
        }
        return true;
    }

}
