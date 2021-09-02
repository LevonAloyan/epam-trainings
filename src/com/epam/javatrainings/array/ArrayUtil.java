package com.epam.javatrainings.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public void sortByOddAndEven(int[] array) {
        var oddElements = new ArrayList<>();
        var evenElements = new ArrayList<>();
        var arrayElements = new ArrayList<>();
        var sortedElementsEvenByOdd = new ArrayList<>();
        var sortedElementsOddByEven = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                evenElements.add(i);
            } else oddElements.add(i);
        }

        arrayElements.addAll(evenElements);
        arrayElements.addAll(oddElements);

        //even -> odd
        for (int i = 0, j = 0; i < evenElements.size() && j < oddElements.size(); i++, j++) {
            sortedElementsEvenByOdd.add(evenElements.get(i));
            sortedElementsEvenByOdd.add(oddElements.get(j));
        }

        //odd -> even
        for (int i = 0, j = 0; i < evenElements.size() && j < oddElements.size(); i++, j++) {
            sortedElementsOddByEven.add(oddElements.get(j));
            sortedElementsOddByEven.add(evenElements.get(i));
        }
        System.out.println("Sort even by odd: " + sortedElementsEvenByOdd);
        System.out.println("Sort odd by even: " + sortedElementsOddByEven);
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max)
                max = i;
        }
        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
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
        for (int i : array) {
            sum += i;
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
        var newArray = new int[array.length];
        int j = array.length;
        for (int k : array) {
            newArray[j - 1] = k;
            j = j - 1;
        }
        return newArray;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        //variant 1
        for (int i : array) {
            System.out.print(i + " ");
        }
        //variant 2
        System.out.println(Arrays.toString(array));
    }


}
