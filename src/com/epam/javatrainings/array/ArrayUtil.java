package com.epam.javatrainings.array;

public class ArrayUtil {
    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (isOdd(array[i]) && isOdd(array[i + 1])) {
                for (int j = i + 1; j < array.length - 1; j++) {
                    if (!isOdd(array[j + 1])) {
                        swap(array, i + 1, j + 1);
                        break;
                    }
                }
            } else if (!isOdd(array[i]) && !isOdd(array[i + 1])) {
                for (int j = i + 1; j < array.length - 1; j++) {
                    if (isOdd(array[j + 1])) {
                        swap(array, i + 1, j + 1);
                        break;
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
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
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
            if (min > array[i]) {
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
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            swap(array, i, length - i - 1);
        }
        return array;//or we can change method return type to void
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static boolean isOdd(int a) {
        return (a & 1) == 1;
    }
}
