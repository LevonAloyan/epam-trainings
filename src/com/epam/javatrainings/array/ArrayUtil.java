package com.epam.javatrainings.array;

public class ArrayUtil {

    /**
     * Sorts the array elements by odd and even number
     * such that if first number is odd then second must be even number
     * this means that it will be found the next even number and swap with the second element
     * if the second element is odd. And so on for the next elements of the array
     *
     */
    public void sortByOddAndEven(int[] array) throws EmptyArrayException {
        if(array.length==0)
            throw new EmptyArrayException("Array has no items");
        int oddEvenControl=array[0]%2;
        for (int j=1;j<array.length-1;j++)
        {
            boolean found=false;
            for (int i = j+1; i < array.length; i++) {
                if (array[i] % 2 == oddEvenControl%2)
                {
                    swap(i,j,array);
                    found=true;
                    oddEvenControl++;
                    break;
                }
            }
            if(!found)
                break;
        }
    }
    private void swap(int i,int j,int[] array)
    {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    /**
     * Return maximum element from given array
     */
    public static int getMaximum(int[] array) throws EmptyArrayException{
        if(array.length==0)
            throw new EmptyArrayException("Array has no items");
        int max=array[0];
        for (var a :array) {//can do it with simple for-loop for more effective work
            if (a > max)
                max=a;
        }
        return max;
    }

    /**
     * Return minimum element from given array
     */
    public static int getMinimum(int[] array) throws EmptyArrayException {
        if(array.length==0)
            throw new EmptyArrayException("Array has no items");
        int min=array[0];
        for (var a :array) {//can do it with simple for-loop for more effective work
            if (a < min)
                min=a;
        }
        return min;
    }

    /**
     * Calculates the sum of specified array  elements
     *
     * @param array specified int array
     * @return the sum of the specified array elements
     */
    public static int getSum(int[] array) throws EmptyArrayException{
        if(array.length==0)
            throw new EmptyArrayException("Array has no items");
        int sum=0;
        for (var a :array) {
            sum+=a;
        }
        return sum;
    }

    /**
     * Revers given array
     * Example:
     * Given array [2,5,7,3,2,6]
     * Expected array [6,2,3,7,5,2]
     */
    public static int[] reverse(int[] array) throws EmptyArrayException {
       //can do this more efficient way , without using twice more storage. but wrote more simple varitant
        if(array.length==0)
            throw new EmptyArrayException("Array has no items");
        int[] reversed=new int[array.length];
        for (int i=0;i<array.length;i++)
        {
            reversed[(array.length-(i+1))]=array[i];
        }
        return reversed;
    }

    /**
     * Prints all elements in an array.
     *
     * @param array the array to print
     */
    public static void print(int[] array) {
        if(array.length==0)
            System.out.print("Array is Empty");
        for (var a :array) {
            System.out.print(a+" ");
        }
    }


}
