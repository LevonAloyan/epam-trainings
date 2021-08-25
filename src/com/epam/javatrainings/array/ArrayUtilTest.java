package com.epam.javatrainings.array;

import java.util.Arrays;

public class ArrayUtilTest {

    public static void main(String[] args) {

        int[] array = {15, 0, 2, 4, 7, 1, 21, 13, 12, 54, 31, 28};

        ArrayUtil.sortByOddAndEven(array);
        System.out.println(Arrays.toString(array)); //output -> [15, 2, 7, 0, 1, 12, 13, 4, 31, 28, 21, 54]

        int max = ArrayUtil.getMaximum(array);
        System.out.println(max); //output -> 54

        int min = ArrayUtil.getMinimum(array);
        System.out.println(min); //output -> 0

        int sum = ArrayUtil.getSum(array);
        System.out.println(sum); //output -> 188

        System.out.println("Array before revers : " + Arrays.toString(array));
        ArrayUtil.reverse(array);
        System.out.println("Array after revers : " + Arrays.toString(array));
        //output ->
        // Array before revers : [0, 1, 2, 4, 7, 12, 13, 15, 21, 28, 31, 54]
        // Array after revers : [54, 31, 28, 21, 15, 13, 12, 7, 4, 2, 1, 0]

        ArrayUtil.print(array); //output -> 54 31 28 21 15 13 12 7 4 2 1 0
    }
}
