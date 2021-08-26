package com.epam.javatrainings.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array) {
        Arrays.sort (array);
        boolean isFirstEven = (array[0] % 2 == 0);

        List<Integer> odd = new ArrayList<Integer> ();
        List<Integer> even = new ArrayList<Integer> ();
        List<Integer> sortedArray = new ArrayList<Integer> ();

        for (int i : array) {
            if (i % 2 == 0) even.add (i);
            else odd.add (i);
        }
        if (isFirstEven = false)
            if (odd.size () > even.size ()) {
            for (int j = 0; j < odd.size (); j++) {
                sortedArray.add (odd.get (j));
                if (j < even.size ()) sortedArray.add (even.get (j));
            }
        } else  {
            for (int j = 0; j < even.size (); j++) {
                if (j < odd.size ()) sortedArray.add (odd.get (j));
                sortedArray.add (even.get (j));
            }
        } else if (isFirstEven = true)
            if (odd.size () < even.size ()) {
            for (int j = 0; j < even.size (); j++) {
                sortedArray.add (even.get (j));
                if (j < odd.size ())
                    sortedArray.add (odd.get (j));
            }
        } else {
            for (int j = 0; j < odd.size (); j++) {
                sortedArray.add (odd.get (j));
                if (j < even.size ())
                    sortedArray.add (even.get (j));
            }
        }
        System.out.println (sortedArray);
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for (Integer i : array) {
            if (max < i) max = i;
        }
        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];
        for (Integer i : array) {
            if (min >i) min = i;
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
        return Arrays.stream (array).sum ();
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        int t;
        for (int i = 0; i < array.length / 2; i++) {
            t = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = t;
        }
        return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        System.out.println ("");
        for (Integer i : array) System.out.print (i + " ");
    }


}
