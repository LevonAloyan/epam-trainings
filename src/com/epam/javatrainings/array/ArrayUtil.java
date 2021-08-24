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
        boolean stoping = false;
        for(int i=0;i<array.length-2&&!stoping;i++)
        {
            boolean findingNext=false;
            for(int j=i+1;j<array.length&&!findingNext;j++)
            {

               if(!(array[j]%2==array[i]%2)) {
                   int forSwap = 0;
                   findingNext = true;
                   if (!(j == i + 1)) {
                       forSwap = array[i + 1];
                       array[i + 1] = array[j];
                       array[j] = forSwap;
                   }

               }


            }
            if(!findingNext)
            {
                stoping=true;
            }

        }
    }

    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) {
        int maximum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>maximum)
            {
                maximum=array[i];
            }
        }
        return maximum;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) {
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]<minimum)
            {
                minimum=array[i];
            }
        }
        return minimum;
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) {
        int sum=0;
        for(int i=0;i<array.length;i++)
        {
            sum+=array[i];
        }
        return sum;
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public int[] reverse(int[] array) {
        for(int i=0;i<array.length/2;i++)
        {
            int forSwap=0;
            forSwap=array[array.length-1-i];
            array[array.length-1-i]=array[i];
            array[i]=forSwap;
        }
       return array;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void  print(int[] array)
    {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }


}
