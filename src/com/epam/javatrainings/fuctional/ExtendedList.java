package com.epam.javatrainings.fuctional;

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
        super ();
    }

    public ExtendedList(List<Integer> asList) {
        super((Collection<? extends T>) asList);
    }

    public void trimToSize() {
        super.trimToSize ();
    }

    public void printList(){
        this.forEach(System.out::println);
    }

   public <R> List<R> map(Function<T,R> function){
        return this.stream().map(function).collect(Collectors.toList());}

    public List<T> fill(Supplier<T> supplier,int size){
        return Stream.generate (supplier)
                .limit(size)
                .collect(Collectors.toList());
        }
        public boolean forAll(Predicate<T> predicate ){
        return this.stream().allMatch (predicate);
        }
        public List<T> partition(Predicate<T> predicate){
            Map<Boolean, List<T>>map = this.stream().collect(Collectors.partitioningBy (predicate));
            return map.containsKey (true)? map.get (true):map.get (false);
        }
        public T reduce(BinaryOperator<T> operator, T t){
        return this.stream().reduce (t,operator);
        }
}

