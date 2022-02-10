package java8;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ExtendList<Integer> extendList = new ExtendList<>();

        extendList.addAll(List.of(1, 2, 55, 24, 11, 15));

        //list's members demo
        System.out.print("My list: ");
        extendList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //map demo
        List<Integer> integers = extendList.map(x -> (x * x));
        System.out.println("x's second degree: " + integers);

        //fill demo
        ExtendList<Integer> list = new ExtendList<>();

        list.fill(() -> new Random().nextInt(100), 5);
        System.out.println("Filled with Random members: " + list);

        //forAll demo
        boolean isEven = extendList.forAll((i) -> i % 2 == 0);
        System.out.println("Is list elements even: " + isEven);

        //partition
        List[] lists = extendList.partition(i -> i % 2 != 0);

        System.out.print("Lists odd members: " + lists[0]);
        System.out.print("\nLists even members: " + lists[1]);

        //reduce
        int sum = extendList.reduce(
              /*  with lambda
                        (acc, element) ->acc + element*/
        //with method reference
        Integer::sum, 0);
        System.out.println("\nList's elements sum: " + sum);
    }
}
