package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] array = {2, 8, 3, 5, 4, 10, 7, 11};

        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.sortByOddAndEven(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        //
        System.out.println("\nMaximum value is: " + ArrayUtil.getMaximum(array));
        //
        System.out.println("Minimum value is: " + ArrayUtil.getMinimum(array));
        //
        System.out.println("Sum is: " + ArrayUtil.getSum(array));
        //
        ArrayUtil.print(array);
        //
        ArrayUtil.reverse(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
/*
    public static void merge(int i, int j, int[] array) {
        int k = array[i];
        array[i] = array[i + 1];
        array[i + 1] = k;
    }*/
