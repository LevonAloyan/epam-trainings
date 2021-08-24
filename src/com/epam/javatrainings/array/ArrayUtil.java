package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public static void sortByOddAndEven(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {                             //checks if current is odd or even
                boolean found = false;
                for(int j = i + 1; j < array.length; j++) {         //finds even in the array
                    if(found == false && array[j] % 2 == 0) {
                        int temp = array[i + 1];
                        array[i + 1] = array[j];
                        array[j] = temp;
                        found = true;
                    }
                }
            } else {
                boolean found = false;
                for(int j = i + 1; j < array.length; j++) {         //finds odd in the array
                    if(found == false && array[j] % 2 != 0) {
                        int temp = array[i + 1];
                        array[i + 1] = array[j];
                        array[j] = temp;
                        found = true;
                    }
                }
            }
        }
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for(int i = 0; i < array.length; i++) {
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
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
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
        for(int i = 0; i < array.length; i++) {
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
        for(int i = 0, j = array.length - 1; i < (array.length / 2); i++, j--) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
