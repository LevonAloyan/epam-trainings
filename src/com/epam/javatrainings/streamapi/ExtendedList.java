package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExtendedList extends ArrayList {

    public static <T, G> List<G> map(List<T> list, Function<T, G> mapperFunction) {
        return list.stream()
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public static void fill(List<Integer> list) {
        Random random = new Random();
        List<Integer> listUpdate = list.stream()
                .map(x -> random.nextInt(100))
                .collect(Collectors.toList());

        listUpdate.forEach(System.out::println);
    }

    public static <T> boolean forAll(List<T> list, Predicate<T> predicate) {
        boolean result = list.stream()
                              .allMatch(predicate);
        return result;
    }

    public static <T> Object[] partition(List<T> list, Predicate<T> predicate) {
        Object[] result = new Object[2];
        List<T> predicateExecuted = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        result[0] = predicateExecuted;
        List<T> predicateNotExecuted = list.stream()
                .filter(predicate.negate())
                .collect(Collectors.toList());
        result[1] = predicateNotExecuted;

        return result;

    }


    public static Integer reduce(List<Integer> list, String binaryOperator, int neutralElement) {
        Integer result = neutralElement;

        if (binaryOperator.equals("+")) {
            for (var x : list) {
                result += x;
            }
            return result;
        } else if (binaryOperator.equals("-")) {
            for (var x : list) {
                result -= x;
            }
            return result;
        } else if (binaryOperator.equals("*")) {
            for (var x : list) {
                result *= x;
            }
            return result;
        } else if (binaryOperator.equals("/")) {
            for (var x : list) {
                result /= x;
            }
            return result;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(4);
        test.add(4);
//        for (var x: map(test, x -> x * x)) {
//            System.out.println(x);
//        }
//
//        fill(test);

//        System.out.println(forAll(test, x -> x % 2== 0));

//        System.out.println(Arrays.deepToString(partition(test, x -> x % 2== 0)));

//        System.out.println(reduce(test, "+", 0));


    }

}
