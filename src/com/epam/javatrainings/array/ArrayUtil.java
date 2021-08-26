package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public void sortByOddAndEven(int[] array) {
       for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if ((array[i] % 2 == 0 && array[j] % 2 == 0) || (array[i] % 2 != 0 && array[j] % 2 != 0)) {
                    if (array[i] % 2 == 0) {
                        for (int k = j + 1; k < array.length-2; k++) {
                            if (array[k] % 2 != 0) {
                                int t = array[j];
                                array[j] = array[k];
                                array[k] = t;
                                break;
                            }
                        }
                        break;
                    }else {
                        for (int k = j + 1; k < array.length-1; k++) {
                            if (array[k] % 2 == 0) {
                                int t = array[j];
                                array[j] = array[k];
                                array[k] = t;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
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
            
        int minimum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }

        return minimum;
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

        int reversedArray[] = new int[array.length];
        int index = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[index] = array[i];
            index++;
        }

        return reversedArray;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        
            for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

}
