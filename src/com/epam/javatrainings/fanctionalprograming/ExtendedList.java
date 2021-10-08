package com.epam.javatrainings.fanctionalprograming;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList extends ArrayList {
    public <T, R> List<R> map(List<T> list, Function<T, R> function) {

        return list.stream().map(function).collect(Collectors.toList());
    }

    public <T> List<T> fill(Supplier<T> supplier, int length) {
        return Stream.generate(supplier).limit(length).collect(Collectors.toList());
    }

    public <T> Boolean forAll(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public <T> List<List<T>> partition(List<T> list, Predicate<T> predicate) {
        List<List<T>> lists = new ArrayList<>();
        lists.add(0, list.stream().filter(predicate).collect(Collectors.toList()));
        lists.add(1, list.stream().filter(predicate.negate()).collect(Collectors.toList()));
        return lists;
    }

    public <T> Object reduce(List<T> list, BinaryOperator<T> binaryOperator, T neturalelement) {
        return list.stream().reduce(neturalelement,binaryOperator);
    }
}
