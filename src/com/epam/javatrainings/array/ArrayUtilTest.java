package com.epam.javatrainings.array;

/**
 * @author Artur Mkrtumyan
 */
public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,7,3,2,6};
        //Test method getMinimum
        System.out.println(ArrayUtil.getMinimum(arr));
        //Test method getMaximum
        System.out.println(ArrayUtil.getMaximum(arr));
        //Test method reverse and print
        ArrayUtil.print(ArrayUtil.reverse(arr));
        System.out.println();
        //Test method sortByOddAndEven
        ArrayUtil.sortByOddAndEven(arr);
        ArrayUtil.print(arr);
    }
}
