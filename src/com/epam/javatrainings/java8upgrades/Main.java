package com.epam.javatrainings.java8upgrades;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
            testing map()
        */
        ExtendedList<Integer> integers = new ExtendedList<>();
        integers.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> mappedIntegers = integers.map((x) -> x * x);

        System.out.println("After applying map");
        printList(mappedIntegers);
        System.out.println();

        /*
            testing fill()
        */
        integers.clear();
        integers.fill(() -> (int) Math.floor(Math.random() * 101), 10);

        System.out.println("After applying fill");
        printList(integers);
        System.out.println();

        /*
            testing forAll()
        */
        boolean evenCheck = integers.forAll((number) -> number % 2 == 0);
        System.out.println("All elements in the list are even: " + evenCheck);

        integers.clear();
        integers.addAll(List.of(2, 4, 6, 8, 10));
        evenCheck = integers.forAll((number) -> number % 2 == 0);
        System.out.println("All elements in the list are even: " + evenCheck);
        System.out.println();

        /*
            testing partition()
        */
        integers.clear();
        integers.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer>[] partition = integers.partition((number) -> number % 2 == 0);
        System.out.print("Evens: ");
        printList(partition[0]);
        System.out.print("Odds: ");
        printList(partition[1]);
        System.out.println();

        /*
            testing reduce()
        */
        integers.clear();
        integers.addAll(List.of(1, 2, 3, 4, 5));

        Integer reduce = integers.reduce((x, y) -> x + y, 0);
        System.out.println("Sum: " + reduce);

        reduce = integers.reduce((x, y) -> x * y, 1);
        System.out.println("Product: " + reduce);

    }

    public static <T> void printList(List<T> list) {
        for(T value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
