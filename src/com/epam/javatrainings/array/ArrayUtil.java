package com.epam.javatrainings.array;

import java.util.*;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array) {

        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        for (int k : array)
            if (k % 2 == 0) {
                even.add(k);
            } else {
                odd.add(k);
            }
        int index = 0, i = 0, j = 0;

        boolean flag = false;
        if (array[0] % 2 == 0)
            flag = true;
        while (index < array.length) {
            if (flag) {
                array[index] = even.get(i);
                i += 1;
            } else {
                array[index] = odd.get(j);
                j += 1;
            }
            index += 1;
            flag = !flag;
        }
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        int[] result = new int[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = array[i];
        }
        return result;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

}