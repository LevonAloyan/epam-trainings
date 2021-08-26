package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array 2,6,5,4,7
     */
 /*:


   public static void sortByOddAndEven(int[] array) {
        int[] sortedArray = new int[array.length];
        boolean isEven = false;
        int temp;
        sortedArray[0] = array[0];
        if (array[0] % 2 == 0) {
            isEven = true;
        }
        for (int i = 0; i < array.length-1; i++) {
           if( isEven & array[i+1]%2!=0){
               sortedArray[i+1]=array[i+1];
               isEven=false;
               i++;
           }else if (isEven & array[i+1]%2==0){
               temp = array[+1];
               array[i]= array[i+1];
               array[i+1]=array[i];
           }
           else if (!isEven & array[i+1]%2==0) {
               isEven = true;
               sortedArray[i] = array[i];
                      }
           else if(!isEven & array[i+1]%2!=0){
               temp = array[i];
               array[i]= array[i+1];
               array[i+1]=array[i];
           }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(sortedArray[i] + "  ");
        }
    }
*/

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
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
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
        int[] reversedArray;
        reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
            System.out.print(reversedArray[i] + " ");
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
            System.out.print(array[i] + " ");
        }

    }

}
