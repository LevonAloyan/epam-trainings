package com.epam.javatrainings.extendedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExtendedListDemo {
    public static void main(String[] args) {

        ExtendedList<Integer> extendedList = new ExtendedList<>();
        extendedList.addAll(List.of(1, 3, 4, 5, 6, 932, 32, 4, 47, 2));

        //map testing
        List<Integer> list = new ArrayList<>();
        list = extendedList.map((x) -> x * x);
        System.out.println(list);

        //fill test
        List<Integer> list1 = new ArrayList<>();
        Random random = new Random();
        list1 = extendedList.fill(() -> ((new Random()).nextInt(100)), 10);
        System.out.println(list1);

        //forAll test
        boolean isEven = extendedList.forAll((x) -> x % 2 == 0);
        System.out.println("extendedList is even : " + isEven);
        ExtendedList<Integer> extendedList1 = new ExtendedList<>();
        extendedList.addAll(List.of(2, 4, 68, 8));
        isEven = extendedList1.forAll((x) -> x % 2 == 0);
        System.out.println("extendedList1 is even : " + isEven);

        //partition test
        List[] lists = extendedList.partition((e) -> e % 2 == 0);
        System.out.println("even nums " + lists[0]);
        System.out.println("odd nums " + lists[1]);

        //reduce test
        int sum = extendedList.reduce(Integer::sum, 0);
        System.out.println(sum);

    }
}
