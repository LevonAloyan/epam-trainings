package com.epam.javatrainings.array;

import java.util.Random;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] randomInts = new Random().ints(9, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();

        System.out.print("Original array: ");
        ArrayUtil.print(randomInts);

        System.out.print("\nSorted: \t\t");
        new ArrayUtil().sortByOddAndEven(randomInts);

        System.out.println("\nGet max: \t\t" + ArrayUtil.getMaximum(randomInts));
        System.out.println("Get min: \t\t" + ArrayUtil.getMinimum(randomInts));
        System.out.println("Get sum: \t\t" + ArrayUtil.getSum(randomInts));

        System.out.print("Reversed:\t\t");
        ArrayUtil.print(ArrayUtil.reverse(randomInts));
    }
}
