package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 5, 4, 6, 8, 2};
        System.out.print("Array's elements: ");
        ArrayUtil.print(numbers);

        System.out.println("Sum: " + ArrayUtil.getSum(numbers));

        System.out.println("Minimum: " + ArrayUtil.getMinimum(numbers));

        System.out.println("Maximum: " + ArrayUtil.getMaximum(numbers));

        int[] numbersReversed = ArrayUtil.reverse(numbers);
        System.out.print("Reversed Array: ");
        ArrayUtil.print(numbersReversed);

        ArrayUtil.sortByOddAndEven(numbers);
        System.out.print("Sorted Array by Even & Odd: ");
        ArrayUtil.print(numbers);
    }
}
