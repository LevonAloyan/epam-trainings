package com.epam.javatrainings.array;

import com.epam.ArrayUtil;

import java.util.Arrays;

public class ArrayUtilTest {

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] array = {1, 3, 5, 2, 6, 4};
        arrayUtil.sortByOddAndEven(array);

        System.out.println("\n" + "Minimum : " + ArrayUtil.getMinimum(array));
        System.out.println("Maximum : " + ArrayUtil.getMaximum(array));
        System.out.println("Sum : " + ArrayUtil.getSum(array));
        System.out.println("Reverse : " + Arrays.toString(ArrayUtil.reverse(array)));
        ArrayUtil.print(array);
    }
}
