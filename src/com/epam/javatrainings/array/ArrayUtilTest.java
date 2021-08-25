package com.epam.javatrainings.array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int [] array = {-11,4,-13,67,3,1,6};
        // int [] array = {1};
        // int [] array = {};
        System.out.println("Print Array");
        ArrayUtil.print(array);

        System.out.println("");
        System.out.println("sort By Odd And Even");

        int [] arrayTest = {88,3,65,2,7,1,1,1,1,1,8,4,6};
        // int [] arrayTest = {6,6,11, 22, 22, 22,7,22,2,2, 3};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.sortByOddAndEven(arrayTest);

        System.out.println("");

        int max = ArrayUtil.getMaximum(array);
        System.out.println("Max: " + max);

        int min = ArrayUtil.getMinimum(array);
        System.out.println("Min: " + min);

        int sum = ArrayUtil.getSum(array);
        System.out.println("Sum: " + sum);

        System.out.println("");

        int [] arrayForReverse = {2,5,7,3,2,6};
        // int [] arrayForReverse = {2,5,3,2,6};
        // int [] arrayForReverse = {};
        System.out.print("Original: ");
        ArrayUtil.print(arrayForReverse);
        System.out.println("");
        System.out.print("Reversed: ");
        ArrayUtil.print(ArrayUtil.reverse(arrayForReverse));
        System.out.println("");



    }
}
