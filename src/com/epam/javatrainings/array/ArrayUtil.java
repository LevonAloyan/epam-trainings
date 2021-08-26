package com.epam.javatrainings.array;

import java.util.Arrays;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public void sortByOddAndEven(int[] array) {
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }

        int len = array.length;

        if (len == 0) {
            ArrayUtil.print(array);
            return;
        }

        boolean isFirstNumEven = array[0] % 2 == 0;
        int[] source = Arrays.stream(array)
                .filter(n -> isFirstNumEven ? n % 2 == 0 : n % 2 != 0)
                .toArray();

        int[] arrayToMerge = Arrays.stream(array)
                .filter(n -> isFirstNumEven ? n % 2 != 0 : n % 2 == 0)
                .toArray();

        int[] result = new int[len];
        int i = 0, j = 0, k = 0;

        // Merge 'source' and 'arrayToMerge' into 'result'
        while (k < len) {
            if (i < source.length) {
                result[k++] = source[i++];
            }
            if (j < arrayToMerge.length) {
                result[k++] = arrayToMerge[j++];
            }
        }

        ArrayUtil.print(result);
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }

        int max = Integer.MIN_VALUE;

        for (int val : array) {
            if (val > max) {
                max = val;
            }
        }

        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }

        int min = Integer.MAX_VALUE;

        for (int val : array) {
            if (val < min) {
                min = val;
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
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }

        return Arrays.stream(array).reduce(0, Integer::sum);
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }

        int len = array.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = array[len - 1 - i];
        }

        return result;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        if (array == null) {
            throw new NullPointerException("Parameter 'array' cannot be null");
        }
        if (array.length == 0) {
            System.out.print("[]");
            return;
        }

        String delimiter = ", ";
        StringBuilder result = new StringBuilder("[");

        for (int num : array) {
            result.append(num).append(delimiter);
        }

        result.replace(result.length() - 2, result.length(), "]");
        System.out.print(result);
    }


}
