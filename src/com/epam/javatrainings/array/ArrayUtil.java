package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public void sortByOddAndEven(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp;
                if (array[i - 1] % 2 != 0 && array[j] % 2 == 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    break;
                } else if (array[i - 1] % 2 == 0 && array[j] % 2 != 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    break;
                }
            }
        }

    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {

        int maxValue = array[0];
        for(int i=1;i < array.length;i++){
            if(array[i] > maxValue){
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {

        int minValue = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i] < minValue){
                minValue = array[i];
            }
        }
        return minValue;
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

        }return sum;
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }return array;
    }






    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");

        }

    }


}
