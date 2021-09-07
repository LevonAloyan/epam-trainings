package com.epam.javatrainings.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public void sortByOddAndEven(int[] array) {

        boolean flag;

        List<Integer> evenarr = new ArrayList<>();
        List<Integer> oddarr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (array[0] % 2 == 0) {
            flag = true;
        } else {
            flag = false;
        }


        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                evenarr.add(array[i]);
            } else {
                oddarr.add(array[i]);
            }
        }

        int k = 0;

        if (flag) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0 && k < evenarr.size()) {
                    result.add(array[i]);
                    result.add(evenarr.get(k));
                    k++;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 != 0 && k < oddarr.size()) {
                    result.add(array[i]);
                    result.add(oddarr.get(k));
                    k++;
                }
            }
        }

        if (oddarr.size() > evenarr.size()) {
            for (int i = k; i < oddarr.size(); i++) {
                result.add(oddarr.get(i));
            }
        } else {
            for (int i = k; i < evenarr.size(); i++) {
                result.add(evenarr.get(i));
            }
        }

        System.out.println(evenarr);
        System.out.println(oddarr);
        System.out.println(result);


    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
//        Arrays.sort(array);
//        return array[array.length - 1];

    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;

//        Arrays.sort(array);
//        return array[0];
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
            sum = sum + array[i];
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

        int[] revarr = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            revarr[j] = array[i];
            j++;
        }

        return revarr;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }


}
