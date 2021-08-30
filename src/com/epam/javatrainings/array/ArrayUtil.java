package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array) {
        for(int i = 1; i < array.length - 1; i++) {
            if((array[i-1] + array[i]) % 2 == 0) {
                for(int j = i + 1; j < array.length; j++) {
                    if((array[i] + array[j]) % 2 != 0) {
                        swap(array, i, j);
                        break;
                    }
                }
            }
        }
    } 
 

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
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
        for (int i : array) {
            sum += i;
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
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }

        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) { 
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
