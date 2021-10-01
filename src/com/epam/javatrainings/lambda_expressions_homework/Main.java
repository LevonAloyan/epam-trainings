package com.epam.javatrainings.lambda_expressions_homework;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Integer[] numbers = {1, 5, 4, 8, 13, 6};

    public static void main(String[] args) {
        System.out.println("ExtendList 'map' method");
        ExtendedList<Integer> integerExtendedList = new ExtendedList<>(Arrays.asList(numbers));
        List<Integer> map = integerExtendedList.map(x -> x * x);
        map.forEach(System.out::println);

        System.out.println("\nExtendList 'fill' method");
        integerExtendedList = new ExtendedList<>();
        List<Integer> fill = integerExtendedList.fill(() -> new Random().nextInt(100), 10);
        fill.forEach(System.out::println);

        System.out.println("\nExtendList 'forAll' method");
        integerExtendedList = new ExtendedList<>(Arrays.asList(numbers));
        boolean b = integerExtendedList.forAll(x -> x % 2 != 0);
        System.out.println(b);

        System.out.println("\nExtendList 'partition' method");
        List<Integer> evenNumbers = integerExtendedList.partition((x) -> x % 2 == 0);
        List<Integer> oddNumbers = integerExtendedList.partition((x) -> x % 2 != 0);
        System.out.println("\nEven numbers");
        evenNumbers.forEach(System.out::println);
        System.out.println("\nOdd numbers");
        oddNumbers.forEach(System.out::println);

        System.out.println("\nExtendList 'reduce' method");
        System.out.println(integerExtendedList.reduce(Integer::sum, 0));
    }
}
