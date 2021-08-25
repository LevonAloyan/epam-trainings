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
        List<Integer>oddArray = new ArrayList<>();
        List<Integer> evenArray = new ArrayList<>();
        List<Integer> sortedArray = new ArrayList<>();
        for (int j : array) {
            if (j % 2 == 0)
                evenArray.add(j);
            else oddArray.add(j);
        }
       if(array[0] %2 == 0){
       for (int i =0; i<array.length; i++) {
           if (evenArray.size() == 0) {
               sortedArray.addAll(oddArray);
               break;
           }
           if(oddArray.size() == 0){
               sortedArray.addAll(evenArray);
               break;
           }
           if (i % 2 == 0)
               sortedArray.add(evenArray.remove(0));
           else sortedArray.add(oddArray.remove(0));
       }
       }
       else {
           for (int i =0; i<array.length; i++) {
               if (evenArray.size() == 0) {
                   sortedArray.addAll(oddArray);
                   break;
               }
               if(oddArray.size() == 0){
                   sortedArray.addAll(evenArray);
                   break;
               }
               if (i % 2 == 0)
                   sortedArray.add(oddArray.remove(0));
               else sortedArray.add(evenArray.remove(0));
           }
       }
        for (Integer integer : sortedArray) System.out.println(integer);
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for (int j : array)
            if (j > max)
                max = j;

        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];
        for (int j : array)
            if (j < min)
                min = j;

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
        for (int j : array)
            sum += j;

        return sum;
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        int [] tempArray = new int[array.length];
        for(int i =0; i< array.length; i++)
            tempArray[i] = array[array.length - 1 - i];

        return tempArray;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int j : array) System.out.println(j);
    }
}
