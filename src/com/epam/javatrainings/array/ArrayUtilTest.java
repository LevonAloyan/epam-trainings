package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 2, 9, 3, 6, 4, 8};

        ArrayUtil util = new ArrayUtil();
        util.sortByOddAndEven(arr);

        ArrayUtil.print(arr);

        System.out.println(ArrayUtil.getMaximum(arr));
        System.out.println(ArrayUtil.getMinimum(arr));
        System.out.println(ArrayUtil.getSum(arr));

        ArrayUtil.print(ArrayUtil.reverse(arr));

    }
}
