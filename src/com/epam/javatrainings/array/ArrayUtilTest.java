package com.epam.javatrainings.array;

import java.util.Arrays;

public class ArrayUtilTest {

    public static void main(String[] args) {
<<<<<<< HEAD
        int[] array = {1, 6, 8, 3, 5, 4, 10, 7};
=======
        int array[] = {6, 1, -3, 100, 25, 800, -500,};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.sortByOddEven(array);
        arrayUtil.print(array);
        int max = arrayUtil.getMaximum(array);
        System.out.println("maxium" + " " + max);
        int min = arrayUtil.getMinimum(array);
        System.out.println("minimum" + " " + min);
        int sum=arrayUtil.getSum(array);
        System.out.println("sum"+" "+sum);
//        System.out.println(Arrays.toString(array));
        System.out.println("reverse");
        int reversd []=arrayUtil.reverse(array);
        System.out.println(Arrays.toString(reversd));
>>>>>>> master

        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.sortByOddAndEven(array);
        //
        System.out.println("Maximum value is: " + ArrayUtil.getMaximum(array));
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
