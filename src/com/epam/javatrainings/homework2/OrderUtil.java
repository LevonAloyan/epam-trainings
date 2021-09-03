package com.epam.javatrainings.homework2;

public class OrderUtil {
    private static int[] numbers = new int[90000];
    private static int size = 0;

    private OrderUtil(){}

    private static boolean containsNumber(int number, int[] array) {
        for (int i = 0; i < size; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static int generateOrderNumber() {
        int result;
        int counter = 0;
        do {
            counter++;
            result = 10000 + (int) (Math.random() * 90000);
            if (counter == 90000) {
                break;
            }
        }
        while (containsNumber(result, numbers));
        if (counter == 90000) {
            return -1;
        }
        return result;
    }

}
