package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
      var ArrayUtil1=new ArrayUtil();
      int[] arrayTest={1,3,3,5,6,2,4,8,5};
      ArrayUtil1.sortByOddAndEven(arrayTest);
      ArrayUtil1.print(arrayTest);
      System.out.println(ArrayUtil1.getMaximum(arrayTest));
      System.out.println(ArrayUtil1.getMinimum(arrayTest));
      System.out.println(ArrayUtil1.getSum(arrayTest));
      int []reversedArrayTest=ArrayUtil1.reverse(arrayTest);
      ArrayUtil1.print(reversedArrayTest);

    }
}
