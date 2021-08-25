package com.epam.javatrainings.array;

public class ArrayUtil {
    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public void sortByOddAndEven(int[] array) {
        int[] sortedArrayByOddAndEven = new int[array.length];
        for (int i = 0; i < sortedArrayByOddAndEven.length; i++) {
            sortedArrayByOddAndEven[i] = array[i];
        }
        sortedArrayByOddAndEven[0] = array[0];
        for (int i = 0; i < array.length; i++) {
            if (sortedArrayByOddAndEven[i] % 2 != 0)
                for (int j = i; j < sortedArrayByOddAndEven.length; j++) {
                    int element;
                    if (sortedArrayByOddAndEven[j] % 2 == 0 && i + 1 < array.length) {
                        element = sortedArrayByOddAndEven[j];
                        sortedArrayByOddAndEven[j] = array[i + 1];
                        sortedArrayByOddAndEven[i + 1] = element;
                        break;
                    }
                }
            else {
                for (int j = i; j < sortedArrayByOddAndEven.length; j++) {
                    int element;
                    if (sortedArrayByOddAndEven[j] % 2 != 0 && i + 1 < array.length) {
                        element = sortedArrayByOddAndEven[j];
                        sortedArrayByOddAndEven[j] = array[i + 1];
                        sortedArrayByOddAndEven[i + 1] = element;
                        break;
                    }
                }
            }

        }
        print(sortedArrayByOddAndEven);
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int maxElement = array[0];
        for (int element : array) {
            if (maxElement < element) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int minElement = array[0];
        for (int element : array) {
            if (minElement < element) {
                minElement = element;
            }
        }
        return minElement;
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
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
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        System.out.print("[");
        for (int element : array) {
            System.out.print(element + ",");
        }
        System.out.print("]");
    }


}
