package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.*;

public class ExtendList<T> extends ArrayList<T> {
    //map
    public <R> List<R> map(Function<T, R> f) {
        return this.stream()
                .map(f)
                .collect(Collectors.toList());
    }

    //fill
    public void fill(Supplier<T> s, long quantity) {
        this.addAll(Stream.generate(s)
                .limit(quantity)
                .collect(Collectors.toList()));
    }

    //for All
    public boolean forAll(Predicate<T> predicate) {
        return this.stream()
                .allMatch(predicate);
    }

    //partition
    public List[] partition(Predicate<T> p) {
        List[] lists = new List[2];

        Map<Boolean, List<T>> booleanListMap = this.stream()
                .collect(Collectors
                        .partitioningBy(p));

        lists[0] = booleanListMap.get(true);
        lists[1] = booleanListMap.get(false);

        return lists;
    }

    //reduce
    public T reduce(BinaryOperator<T> binaryOperator, T neutralElement) {
        return this.stream()
                .reduce(neutralElement, binaryOperator);
    }
}
