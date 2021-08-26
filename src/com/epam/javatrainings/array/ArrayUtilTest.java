package com.epam.javatrainings.array;

import java.util.Arrays;

public class ArrayUtilTest {

    public static void main(String[] args) {
        var array = new int[]{2, 5, 7, 3, 2, 6}; //or var -> int[]
        System.out.print("Print array: "); ArrayUtil.print(array);
        System.out.println("Reverse: " + Arrays.toString(ArrayUtil.reverse(array)));
        System.out.println("Sum: " + ArrayUtil.getSum(array));
        System.out.println("Get min: " + ArrayUtil.getMinimum(array));
        System.out.println("Get max: " + ArrayUtil.getMaximum(array));
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.sortByOddAndEven(array);
    }
}
