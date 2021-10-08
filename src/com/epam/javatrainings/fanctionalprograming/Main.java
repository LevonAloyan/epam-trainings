package com.epam.javatrainings.fanctionalprograming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ExtendedList extendedList = new ExtendedList();
        List<Integer> maps = new ArrayList<>();
        maps.add(1);
        maps.add(2);
        maps.add(3);
        maps.add(4);
        list = extendedList.map(maps, x -> x * x);
        System.out.println("Map method");
        System.out.println(list);
        System.out.println("fill method");
        extendedList.fill(() -> (new Random()).nextInt(100), 6).forEach(System.out::println);
        System.out.println("forAll method");
        System.out.println(extendedList.forAll(maps, x -> x % 2 == 0));
        System.out.println("partition method");
        System.out.println(extendedList.partition(maps, x -> x % 2 == 0).stream().collect(Collectors.toList()));
        System.out.println("reduce method");
        System.out.println(extendedList.reduce(maps, Integer::sum, 0));
    }
}
