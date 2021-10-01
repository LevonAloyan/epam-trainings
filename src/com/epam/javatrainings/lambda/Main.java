package com.epam.javatrainings.lambda;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("map demo of extendedList");
        ExtendedList<Integer> el = new ExtendedList<>(List.of(1, -2, 3, 1, -5, 0));
        List<Integer> squareList = el.map(x -> x * x);
        System.out.println(squareList);

        List<Double> rootList = el.map(x -> Math.sqrt(x));
        System.out.println(rootList);
        System.out.println();

        System.out.println("fill demo of extendedList");
        el = new ExtendedList<>();
        el.fill(() -> new Random().nextInt(101), 200);
        System.out.println(el);

        el = new ExtendedList<>();
        el.fill(() -> 4, 20);
        System.out.println(el);
        System.out.println();

        System.out.println("forAll demo of extendedList");
        boolean areEven;
        el = new ExtendedList<>(List.of(2, -2, -44, 12, 0));
        areEven = el.forAll((x) -> x % 2 == 0);
        System.out.println(areEven ? "All numbers are even" : "There is an odd value");
        System.out.println();

        System.out.println("partition demo of extendedList");
        el = new ExtendedList<>(List.of(2, 6, 7, 9, 0));
        var parts =  el.partition((x) -> x % 2 == 0);
        System.out.println("Even: " + parts.get(0));
        System.out.println("Odd: " + parts.get(1));

        ExtendedList<String> namesEl = new ExtendedList<>(List.of("Earth", "Mars", "Saturn", "Neptun"));
        var namesParts = namesEl.partition((x) -> x.length() >= 6);
        System.out.println("Long: " + namesParts.get(0));
        System.out.println("Short: " + namesParts.get(1));
        System.out.println();

        System.out.println("forAll demo of extendedList");
        System.out.println("Sum of elements: " + el.reduce(Integer::sum, 0));
        System.out.println("Multiplication of elements: " + el.reduce((x, y) -> x * y, 0));
        System.out.println("Concatenation of elements: " + namesEl.reduce(String::concat, ""));
    }
}
