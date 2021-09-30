package com.epam.javatrainings.extendedlist;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        ExtendedList<Integer> list = new ExtendedList<>();
        list.addAll(List.of(2,4,6,8,10,12,14,1,1,0,3));
        List<Integer> newList = list.map((e) -> e*e);
        System.out.println("List of elements pow(2): " + newList);
        boolean isEven = list.forAll((e) -> e%2 == 0);
        System.out.println("Is all elements in list even? " + isEven);
        List[] list_part = list.partition((e) -> e%2 == 0);
        System.out.println("List of even elements: " + list_part[0]);
        System.out.println("List of odd elements: " + list_part[1]);
        int result = list.reduce(0,Integer::sum);
        System.out.println("Sum of list: " + result);
        ExtendedList<String> strings = new ExtendedList<>();
        strings.addAll(List.of("Hello "," world"," !"));
        String concatString  = strings.reduce("",String::concat);
        System.out.println("String concatenation: " + concatString);
        ExtendedList<Integer> emptyList = new ExtendedList<>();
        boolean isFilled = emptyList.fill(() -> new Random().nextInt(100),10);
        System.out.println("List filled random integers: " + emptyList);
    }
}
