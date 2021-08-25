package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int [] arr = {1, 2, 3, 4, 5, 6};
       // arrayUtil.sortByOddAndEven(arr);
        ArrayUtil.reverse(arr);
        ArrayUtil.print(arr);

    }
}
