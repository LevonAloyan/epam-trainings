package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] arr = {23, 14, 1, 3, 77, 9, 8, 45, 86,61};
        ArrayUtil.print (arr);
        ArrayUtil.reverse (arr);
        ArrayUtil.print (arr);
        System.out.println ("");
        System.out.println (ArrayUtil.getMaximum (arr));
        System.out.println (ArrayUtil.getMinimum (arr));
        ArrayUtil.getSum (arr);
        ArrayUtil.sortByOddAndEven (arr);
        ArrayUtil.print (arr);
    }
}
