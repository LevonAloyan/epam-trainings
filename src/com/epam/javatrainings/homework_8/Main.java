package com.epam.javatrainings.homework_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("*****Test map*******");
        ExtendedList <Integer> testMap = new ExtendedList<>(Arrays.asList(5,7,16));
        testMap.map(e -> e * e).forEach(e -> System.out.print(e + "  "));
        System.out.println();

        System.out.println("*****Test fill******");
        ExtendedList <Integer> testFill = new ExtendedList<>();
        testFill.fill(() -> (int)((Math.random() * (100)) + 0),5);
        testFill.forEach(e -> System.out.print(e + "  "));
        System.out.println();

        System.out.println("*****Test forAll******");
        ExtendedList <Integer> testForAll = new ExtendedList<>(Arrays.asList(11,222,806,3));
        System.out.print("All elements are even:  ");
        System.out.println(testForAll.forAll(e -> e % 2 == 0));

        System.out.println("*****Test partition******");
        ExtendedList <Integer> testPartition = new ExtendedList<>(Arrays.asList(18,664,177,205,1));
        System.out.print("Evens: ");
        testPartition.partition(e -> e % 2 ==0)[0].forEach(e -> System.out.print(e + "   "));
        System.out.println();
        System.out.print("Odds: ");
        testPartition.partition(e -> e % 2 ==0)[1].forEach(e -> System.out.print(e + "   "));
        System.out.println();

        System.out.println("*****Test reduce******");
        ExtendedList <Integer> testReduce = new ExtendedList<>(Arrays.asList(5,36,0,41,8));
        System.out.println("Sum:  " + testReduce.reduce(0,(a,b) -> a+ b));
    }
}
