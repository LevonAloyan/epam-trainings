package com.epam.javatrainings.extendedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList<T> extends ArrayList<T> {

    public <R> List<R> map(Function<T,R> function){return this.stream().map(function).collect(Collectors.toList());}

    public boolean forAll(Predicate<T> predicate){return this.stream().allMatch(predicate);}

    public T reduce(T identity, BinaryOperator<T> accumulator){return this.stream().reduce(identity,accumulator);}

    public boolean fill(Supplier<T> consumer,int limit){
        return this.addAll(Stream.generate(consumer).limit(limit).collect(Collectors.toList()));
    }

    public List[] partition(Predicate<T> predicate){
        List[] list = new List[2];

        Map<Boolean, List<T>> map = this.stream().collect(Collectors.partitioningBy(predicate));
        list[0] = map.get(true);
        list[1] = map.get(false);
        return list;
    }

}
