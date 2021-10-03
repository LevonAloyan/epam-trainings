package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList extends ArrayList {

    public  <T, R> List<R> map(List<T> list, Function<T, R> f) {
        return list.stream()
                .map(f)
                .collect(Collectors.toList());
    }

    public <T> List<T> fill(Supplier<T> supplier, int size) {
        return Stream.generate(supplier).limit(size).collect(Collectors.toList());
    }

    public <T, R>Boolean forAll(List<T> list, Predicate<T> f){
        return list.stream().allMatch(f);
    }

    public <T> List<List<T>> partition(List<T> list, Predicate<T> f){
        List<List<T>> lists = new ArrayList<>();
        lists.add(0, list.stream().filter(f).collect(Collectors.<T>toList()));
        lists.add(1, list.stream().filter(f.negate()).collect(Collectors.toList()));

        return lists;
    }

    public <T> Object reduce(List<T> list, BinaryOperator<T> operator, T neutralElement) {
        return list.stream()
                .reduce(neutralElement, operator);
    }
}
