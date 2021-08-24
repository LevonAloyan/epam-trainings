package com.epam.javatrainings.array;

import java.util.*;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 3, 69, 4, 5, 2, 1, 5};
        sortByOddAndEven(arr);
    }

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */

    public static void sortByOddAndEven(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> evens = new ArrayDeque<>();
        ArrayDeque<Integer> odds = new ArrayDeque<>();

        for (int elm : array) {
            if (elm % 2 == 0) evens.add(elm);
            else odds.add(elm);
        }

        for (int i = 0; i < array.length; i++) {
            if (!evens.isEmpty()) result.add(evens.removeFirst());

            if (!odds.isEmpty()) result.add(odds.removeFirst());
        }
        System.out.println(result);
    }


    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
        return Arrays.stream(array).sum();
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }


}
