package com.epam.javatrainings.lambda_expressions_homework;

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

public class ExtendedList<F> extends ArrayList<F> {
    public ExtendedList(int initialCapacity) {
        super(initialCapacity);
    }

    public ExtendedList(Collection<? extends F> c) {
        super(c);
    }

    public ExtendedList() {
    }

    public <E> List<E> map(Function<F, E> function) {
        return this.stream()
                .map(function)
                .collect(Collectors.toList());

    }

    public List<F> fill(Supplier<F> supplier, int limit) {
        return Stream.generate(supplier)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public boolean forAll(Predicate<F> predicate) {
        return this.stream()
                .allMatch(predicate);
    }

    public List<F> partition(Predicate<F> predicate) {
        Map<Boolean, List<F>> map = this.stream().
                collect(Collectors.partitioningBy(predicate));
        return map.containsKey(true) ? map.get(true) : map.get(false);
    }

    public F reduce(BinaryOperator<F> operator, F neutralElement) {
        return this.stream()
                .reduce(neutralElement, operator);
    }
}
