package com.epam.javatrainings.array;



public class ArrayUtilTest {

    public static void main(String[] args) {
      int[] arr = new int[]{2, 6, -7, 5, 4 };
     ArrayUtil.print(arr);
      System.out.println();
      ArrayUtil.reverse(arr);
      System.out.println();
      System.out.println("array number's sum is " + ArrayUtil.getSum(arr));
      System.out.println("minimum is " + ArrayUtil.getMinimum(arr));
      System.out.println("maximum is " + ArrayUtil.getMaximum(arr));

      ArrayUtil.sortByOddAndEven(arr);

      }





    }

