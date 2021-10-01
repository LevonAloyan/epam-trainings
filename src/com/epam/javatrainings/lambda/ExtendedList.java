package com.epam.javatrainings.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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

    public ExtendedList(int initialCapacity) {
        super(initialCapacity);
    }

    public ExtendedList(Collection<? extends T> c) {
        super(c);
    }

    public <R> List<R> map(Function<T, R> function) {
        return this.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public void fill(Supplier<T> supplier, int quantity) {
        Stream.generate(supplier)
                .limit(quantity)
                .forEach(this::add);
    }

    public boolean forAll(Predicate<T> predicate) {
        return this.stream().allMatch(predicate);
    }

    public ExtendedList<List<T>> partition(Predicate<T> predicate) {
        Map<Boolean, List<T>> map = this.stream()
                                        .collect(Collectors.partitioningBy(predicate));

        return new ExtendedList(List.of(map.get(true), map.get(false)));
    }

    public T reduce(BinaryOperator<T> op, T identity) {
        return this.stream().reduce(identity, op);
    }
}
