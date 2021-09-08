package com.epam.javatrainings.array;

import java.util.NoSuchElementException;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public void sortByOddAndEven(int[] array) {
        // Space - O(1)
        // Time - O(n^2)

        // I am assuming that is not required that the result array should start with odd number,
        // otherwise we can comment out the following block, which will not affect on comlexity
        // if (array.length > 0 && array[0] % 2 == 0) {
        //     for (int i = 1; i < array.length; i++) {
        //         if (array[i] % 2 == 1) {
        //             swap(array, i, 0);
        //             break;
        //        }
        //    }
        // }

        for (int i = 0; i < array.length - 1; i++) {
            // If neigbours are the both odd or even
            if (array[i] % 2 == array[i+1] % 2) {
                // System.out.println(array[i] + " and " + array[i+1]);
                for (int j = i + 1; j < array.length; j++) {
                    // Find the closest following element to i + 1 (if exists)
                    // which's mod is different from i-th element's mode
                    if (array[i] % 2 != array[j] % 2) {
                        swap(array, i + 1, j);
                        break;
                    }
                }
            }
        }

        print(array);
    }

    /**
     * Swaps i-th and j-th elements
     */
    private void swap(int [] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        // Space - O(1)
        // Time - O(n)

        if (array.length == 0) {
            throw new NoSuchElementException("The provided array is empty");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        // Space - O(1)
        // Time - O(n)

        if (array.length == 0) {
            throw new NoSuchElementException("The provided array is empty");
        }

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
        // Space - O(1)
        // Time - O(n)

        if (array.length == 0) {
            throw new NoSuchElementException("The array is empty. It is not possible to sum non existed elements");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
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
        // Space - O(1)
        // Time - O(n)

        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            // Swap end index element with start index element
            int tmp = array[endIndex];
            array[endIndex] = array[startIndex];
            array[startIndex] = tmp;

            // Update array pointers
            startIndex++;
            endIndex--;
        }

        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.print("]");
    }


}
