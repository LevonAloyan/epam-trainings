package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp;
                if (array[i - 1] % 2 != 0 && array[j] % 2 == 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    break;
                } else if (array[i - 1] % 2 == 0 && array[j] % 2 != 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {

        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array[array.length - 1];
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        getMaximum(array);
        return array[0];
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
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
        int k = array.length-1;
        for (int i = 0; i < array.length; i++){
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            k--;
            if(k==i || Math.abs(k-i)==1)
                break;
        }
        return array;

    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for(int a:array) {
            System.out.print(a + " ");
        }
    }


}
