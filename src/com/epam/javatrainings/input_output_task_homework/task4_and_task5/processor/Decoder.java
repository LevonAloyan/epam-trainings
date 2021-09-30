package com.epam.javatrainings.input_output_task_homework.task4_and_task5.processor;

import java.util.Base64;

public class Decoder {
    public static String encryptingCardNumber(String cardNumber) {
        return Base64.getEncoder().encodeToString(cardNumber.getBytes());
    }

    public static String decryptingCardNumber(String cardNumber) {
        return new String(Base64.getDecoder().decode(cardNumber));
    }
}
