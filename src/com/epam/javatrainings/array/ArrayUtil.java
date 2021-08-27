package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    /*public class Main {
        public static void main(String[] args) {
            int array [] = {1,3,2,4,5,7};

            ArrayUtil arrayUtil = new ArrayUtil();
            arrayUtil.sortByOddAndEven(array);

            arrayUtil.print(array);
        }

        public class ArrayUtil {
    public void sortByOddAndEven(int[] array) {
        int j;

        for (int k = 0; k < array.length - 2; k++) {
            j = k + 1;
            while ((array[k] + array[j]) % 2 == 0) {

                j++;
                if (j > array.length) {
                    return;
                }
            }
            swap(array, k + 1, j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(int array []) {
        for (int element: array) {
            System.out.print(element+" ");
        }

    }
}

     */


/**
 * Return maximum element from given array
 */
   /* public class Main {
    public static void main(String[] args) {
       int max [] = {6,66,26,76,16,3,46,33};
       int largest = max[0];
        for (int i = 0; i < 8; i++) {
            if (max[i]>largest) largest = max[i];

        }
        System.out.println("The maximum element is " + largest);
    }
    }
} */

    /**
     * Return minimum element from given array
     */
   /* public class Main {
        public static void main(String[] args) {
            int min [] = {6,66,26,76,16,3,46,33};
            int smallest = min[0];
            for (int i = 0; i < 8; i++) {
                if (min[i]<smallest) smallest = min[i];

            }
            System.out.println("The minimum element is " + smallest);
        }
    }



    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */

   /*public class Main {
       public static void main(String[] args) {
           int arr[] = new int[8];
           arr[0] =1;
           arr[1] =2;
           arr[2] =3;
           arr[3] =4;
           arr[4] =5;
           arr[5] =6;
           arr[6] =7;
           arr[7] =8;

           int sum = 0;

           int lengthOfArray = arr.length;
           for (int i = 0; i < lengthOfArray; i++) {

               sum = sum + arr[i];
           }
           System.out.println(sum);
       }
   }


    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */


   /*public class Main {
       public static void main(String[] args) {
           int [] arr1 = new int[]{2,5,7,3,2,6};
           System.out.println("The original array is : ");
           for (int i = 0; i < arr1.length; i++) {
               System.out.print(arr1[i]);

           }
           System.out.println();
           System.out.println("The reversed array is : ");
           for (int i= arr1.length-1;i>=0; i--) {
               System.out.print(arr1[i]);
           }
       }
   }

    */

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    /*public class Main {
        public static void main(String[] args) {
            String [] arr1 = new String[]{"Red","Yellow","Orange","Blue"};
            System.out.println(arr1);
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);

            }

        }


