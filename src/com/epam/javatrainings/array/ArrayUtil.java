package com.epam.javatrainings.array;

public class ArrayUtil {
    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddEven(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            while ((array[i] + array[j]) % 2 == 0) {
                j++;
                if (j >= array.length) {
                    return;
                }
            }

            swap(array, i + 1, j);
        }
    }

<<<<<<< HEAD
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] % 2 != 0) {
                if (array[i + 1] % 2 == 0) {
                    System.out.print(array[i] + " " + array[i + 1] + " ");
                } else {
                    for (int j = i + 2; j < array.length - 2; j++) {
                        if (array[j] % 2 == 0) {
                            int k = array[i + 1];
                            array[i + 1] = array[j];
                            array[j] = k;
                            System.out.print(array[i] + " " + array[i + 1] + " ");
                        }
                    }
                }
            } else {
                if (array[i + 1] % 2 != 0) {
                    int k = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = k;

                    System.out.print(array[i] + " " + array[i + 1] + " ");
                }
            }
        }
=======
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
>>>>>>> master
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
<<<<<<< HEAD
        for (int i = 0; i < array.length; i++) {
=======
        for (int i = 1; i < array.length; i++) {
>>>>>>> master
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
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
<<<<<<< HEAD
=======

>>>>>>> master
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
        int sum = 0;
<<<<<<< HEAD
        for (int i : array) {
            sum += i;
=======
        for (int j : array) {
            sum += j;
>>>>>>> master
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
<<<<<<< HEAD
        System.out.print("\nExpected array: ");
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int k = array[i];
            array[i] = array[j];
            array[j] = k;
        }
=======
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

>>>>>>> master
        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
<<<<<<< HEAD
        System.out.print("Array's elements: ");
=======
>>>>>>> master
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
