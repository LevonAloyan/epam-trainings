package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     */
    public static void sortByOddAndEven(int[] array){

        int len = array.length;

        if(len > 1){

            String flag = array[0]%2 == 0 ? "even" : "odd";

            sortArray(array, flag);


        }

    }

    /**
     * sorts array using flag
     * @param array
     * @param flag
     */
    private static void sortArray(int[] array, String flag) {

        int len = array.length;


        switch (flag){

            case "odd" :
            {
                for (int i = 1; i < len; i++) {

                    if(array[i] % 2 != 0 && i % 2 != 0){
                        swap(i, array, "odd");
                    }else if(array[i] % 2 == 0 && i % 2 == 0){
                        swap(i,array,"even");
                    }
                }
                break;
            }
            case "even" :
            {
                for (int i = 1; i < len; i++) {

                    if(array[i] % 2 == 0 && i % 2 != 0){
                        swap(i,array,"even");
                    }else if (array[i] % 2 != 0 && i % 2 == 0){
                        swap(i,array,"odd");
                    }
                }
                break;
            }

        }
    }

    /**
     * swap array's elements by given index and flag
     * @param index
     * @param array
     * @param flag
     */

    private static void swap(int index, int[] array, String flag) {

        int len = array.length;

        switch (flag){

            case "odd" :
            {
                for (int i = index; i < len; i++) {

                    if (array[i] % 2 == 0){
                        int temp = array[i];
                        array[i] = array[index];
                        array[index] = temp;
                        break;
                    }
                }
                break;
            }
            case "even" : {

                for (int i = index; i < len; i++) {

                    if (array[i] % 2 != 0){
                        int temp = array[i];
                        array[i] = array[index];
                        array[index] = temp;
                        break;
                    }

                }
                break;
            }
        }


    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) throws EmptyArrayException {

        int len = array.length;

        if (len == 0) {
            throw new EmptyArrayException();
        } else if (len == 1) {
            return array[0];
        } else {
            int max = array[0];
            for (int i = 1; i < len; i++) {

                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }


    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) throws EmptyArrayException {

        int len = array.length;

        if (len == 0) {
            throw new EmptyArrayException();
        } else if (len == 1) {
            return array[0];
        } else {
            int min = array[0];
            for (int i = 1; i < len; i++) {

                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        }


    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) throws EmptyArrayException {

        int len = array.length;

        if (len == 0) {

            throw new EmptyArrayException();
        } else if (len == 1) {

            return array[0];
        } else {

            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += array[i];

            }
            return sum;
        }


    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) throws EmptyArrayException {

        int len = array.length;

        if (len == 0) {

            throw new EmptyArrayException();
        } else if (len == 1) {

            return array;
        } else {
            int[] reversArray = new int[len];

            for (int i = 0; i < len; i++) {

                reversArray[i] = array[len - i - 1];
            }

            return reversArray;
        }


    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {

        if (array.length == 0) {

            System.out.println("[ ]");

        } else {

            StringBuilder sb = new StringBuilder("[");

            for (int el : array) {

                sb.append(el).append(", ");

            }

            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            System.out.println(sb);
        }
    }

}



