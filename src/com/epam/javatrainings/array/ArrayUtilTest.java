package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] intArray = new int[]{ 10,22,36,80,37,59,11,33 };
        System.out.print("Initial array:   ");
        ArrayUtil.print(intArray);
        System.out.println();
        System.out.println("Maximum value:   " + ArrayUtil.getMaximum(intArray));
        System.out.println("Minimum value:   " + ArrayUtil.getMinimum(intArray));
        System.out.println("Sum of array:   " + ArrayUtil.getSum(intArray));
        System.out.print("Array after reversing:   ");
        ArrayUtil.print(ArrayUtil.reverse(intArray));
        System.out.println();
        System.out.print("Array after sorting by odd-even:   ");
        ArrayUtil.sortByOddAndEven(intArray);
        ArrayUtil.print(intArray);

    }
}
