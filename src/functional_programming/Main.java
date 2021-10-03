package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ExtendedList extendedList = new ExtendedList();
        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);

        System.out.println("Test map");
        extendedList.map(l, (x)-> x*x)
                .forEach(System.out::println);

        System.out.println("Test Fill");
        extendedList.fill(() -> ((new Random()).nextInt(100)), 6)
                .forEach(System.out::println);

        System.out.println("Test forAll");
        System.out.println(extendedList.forAll(l, x-> x%2==0));

        System.out.println("Test partition");
        List<List<Integer>> listObject = extendedList.partition(l,  x-> x%2==0);
        System.out.println((listObject));

        System.out.println("Test reduce");
        System.out.println(extendedList.reduce(l, Integer::sum, 0));

    }
}
