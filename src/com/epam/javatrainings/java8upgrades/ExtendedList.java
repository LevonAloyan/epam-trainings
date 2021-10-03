package com.epam.javatrainings.java8upgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList<T> extends ArrayList<T> {

    public ExtendedList() {
        super();
    }

    public <R> List<R> map(Function<T, R> function) {
        List<R> collect = this.stream()
                .map(function)
                .collect(Collectors.toList());
        return collect;
    }

    public void fill(Supplier<T> function, int capacity) {
        Stream.generate(function)
                .limit(capacity)
                .forEach(number -> this.add(number));
    }

    public boolean forAll(Predicate<T> predicate) {
        return this.stream().allMatch(predicate);
    }

    public List<T>[] partition(Predicate<T> predicate) {
        List<T>[] lists = new List[2];
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new ExtendedList<>();
        }
        for(T value : this) {
            boolean check = predicate.test(value) ? lists[0].add(value) : lists[1].add(value);
        }
        return lists;
    }

    public T reduce(BinaryOperator<T> binaryOperator, T neutralElement) {
        return this.stream().reduce(neutralElement, binaryOperator);
    }
}
