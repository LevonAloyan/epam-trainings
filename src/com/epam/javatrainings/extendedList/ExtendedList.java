package com.epam.javatrainings.extendedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList<T> extends ArrayList<T> {


    public <V> List<V> map(Function<T, V> function) {
        return this.stream().map(function).collect(Collectors.toList());
    }

    public <T> List<T> fill(Supplier<T> supplier, int size) {
        return Stream.generate(supplier).limit(size).collect(Collectors.toList());
    }


    public boolean forAll(Predicate<T> predicate) {
        return this.stream().allMatch(predicate);
    }

    public List[] partition(Predicate<T> predicate) {
        List[] lists = new List[2];
        Map<Boolean, List<T>> map = this.stream().collect(Collectors.partitioningBy(predicate));
        lists[0] = map.get(true);
        lists[1] = map.get(false);
        return lists;
    }

    public T reduce(BinaryOperator<T> op, T identity) {
        return this.stream().reduce(identity, op);
    }
}
