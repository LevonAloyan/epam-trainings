package com.epam.javatrainings.fuctional;

import java.util.Arrays;
import java.util.Random;

public class FunctionalProg {
  public static void main(String[] args) {

      Integer[] nums = {23,65,87,98,41,32,31,79};

      ExtendedList<Integer> myList = new ExtendedList<>(Arrays.asList(nums));
      myList.printList ();

      myList.map(x->x*x).forEach(System.out::println);

      myList.fill (()->new Random ().nextInt(100),10).forEach (System.out::println);

      System.out.println(myList.forAll (x-> (x%2)!=0));

      myList.partition (x-> x%2==0).forEach(System.out::println);


      System.out.println(myList.reduce (Integer::sum,0));

  }
}
