package com.epam.javatrainings.funcinterfaces;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Test {
  private static final int NUMBER_COUNT = 5;
  private static final int IDENTITY = 0;

  public static void main(String[] args) {

    ExtendedList<Integer> extendedList = new ExtendedList<>();
    extendedList.addAll(List.of(1, 2, 3));

    UnaryOperator<Integer> unaryOperator = parameter -> parameter * parameter;
    Predicate<Integer> predicateEven = parameter -> parameter % 2 == 0;
    Predicate<Integer> predicateOdd = parameter -> parameter % 2 != 0;
    BinaryOperator<Integer> binaryOperator = (Integer::sum);

    // map method to square each element
    List<Integer> squareList = extendedList.map(unaryOperator);
    System.out.println(squareList);

    // fill method generates random values from 0 to 100
    squareList = extendedList.fill(NUMBER_COUNT);
    System.out.println(squareList);

    // forAll method check Is all elements in list even
    boolean isEven = extendedList.forAll(predicateEven);
    System.out.println(isEven);

    // partition method is collected event items in one list and odd items in another
    List<List<Integer>> listOfList = extendedList.partition(predicateOdd, predicateEven);
    System.out.println(listOfList);

    // reduce method is summing list items
    System.out.println(extendedList.reduce(IDENTITY, binaryOperator));
  }
}
