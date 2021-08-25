package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int []array = {2, 9, 8, 4, 6, 5, 1, 3};

        System.out.println("Max element is " + ArrayUtil.getMaximum(array));
        System.out.println("Min element is " + ArrayUtil.getMinimum(array));
        System.out.println("Sum of array is " + ArrayUtil.getSum(array));
        System.out.println("Array elements");
        ArrayUtil.print(array);
        System.out.println("Reversed array");
        int []arr = ArrayUtil.reverse(array);
        for (int i : arr) System.out.println(i);
        System.out.println("Sort array by odd and even");
        arrayUtil.sortByOddAndEven(array);
    }
}
