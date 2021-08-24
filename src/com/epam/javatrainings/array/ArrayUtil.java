package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public void sortByOddAndEven(int[] array) { // 1 3 2 4 ==> 1 2 3 4
        int even = 0;
        int odd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        if (even == odd) {

            int[] sortedArray = new int[array.length];
            if (array[0] % 2 == 1) {
                sortedArray[0] = array[0];
                for (int i = 1; i < array.length; i++) {
                    if (array[i] % 2 == 1 && i % 2 == 1) {
                        int element = i + 1;
                        boolean b = false;
                        while (!b) {
                            if (array[element] % 2 == 0) {
                                b = true;
                                sortedArray[i] = array[element];
                                array[element] = array[i];
                                array[i] = sortedArray[i];
                            }
                            element++;
                        }
                    } else if (array[i] % 2 == 0 && i % 2 == 0) {
                        int element = i + 1;
                        boolean b = false;
                        while (!b) {
                            if (array[element] % 2 == 1) {
                                b = true;
                                sortedArray[i] = array[element];
                                array[element] = array[i];
                                array[i] = sortedArray[i];
                            }
                            element++;
                        }
                    } else {
                        sortedArray[i] = array[i];
                    }
                }
            }
            for (int i = 0; i < sortedArray.length; i++) {
                System.out.print(sortedArray[i] + " ");
            }
        } else {
            System.out.println("Enter an array with equal odd and even numbers");
        }

    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
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
        int[] reversed = new int[array.length];

        for (int i = reversed.length - 1; i >= 0; i--) {
            reversed[i] = array[i];
        }
        return reversed;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("element " + i + 1 + ": " + array[i]);
        }
    }

}
