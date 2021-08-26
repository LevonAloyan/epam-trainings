package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public static void sortByOddAndEven(int[] array) {
        int length = array.length;
        int temp;
        Boolean swapped  = false, isEven;
        for(int i = 1; i < length; i++){
            isEven = isEven(array[i - 1]);
            if (isEven(array[i]) == isEven &&  i + 1 <= length){
                swapped = false;
                for(int j = i + 1; j < length && !swapped; j++){
                    if(isEven(array[j]) != isEven){
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }

    public static Boolean isEven(int number) {
        return number % 2 == 0;
    }

        /**
         * Return maximum element from given array
         */
    public static int getMaximum(int[] array) {
       int max = array[0];
       for (int temp : array){
           if(temp > max){
               max = temp;
           }
       }
        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int min = array[0];
        for (int temp : array){
            if(temp < min){
                min = temp;
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
        for (int temp : array) {
            sum += temp;
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
        int [] result = new int[length];
        for(int i = 0; i < length; i++){
            result[i] = array[length - i - 1];
        }

        return  result;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int temp : array){
            System.out.print(temp + "  ");
        }
    }


}
