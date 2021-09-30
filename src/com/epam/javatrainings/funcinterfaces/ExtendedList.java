package com.epam.javatrainings.funcinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ExtendedList<E> extends ArrayList<E> {

  public List<E> map(UnaryOperator<E> unaryOperator) {
    return this.stream().map(unaryOperator).collect(Collectors.toList());
  }

  public List<Integer> fill(int numberCount) {
    Random random = new Random();
    return random.ints(numberCount, 0, 100).boxed()
            .collect(Collectors.toList());
  }

  public boolean forAll(Predicate<E> predicate) {
    return this.stream().allMatch(predicate);
  }

  public List<List<E>> partition(Predicate<E> predicateEven, Predicate<E> predicateOdd) {

    List<List<E>> listOfLists = new ArrayList<>();
    List<E> even = this.stream().filter(predicateEven).collect(Collectors.toList());
    List<E> odd = this.stream().filter(predicateOdd).collect(Collectors.toList());

    listOfLists.add(odd);
    listOfLists.add(even);

    return listOfLists;
  }

  public E reduce(E identity, BinaryOperator<E> binaryOperator) {
    return this.stream().reduce(identity, binaryOperator);
  }
}
