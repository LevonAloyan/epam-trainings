package com.epam.javatrainings.array; 

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] array1 = {2, 4, 1, 6, 7, 9, 3, 8};
        int[] array2 = {11, 5, 22, 3, 1, 4, 0};

        ArrayUtil.sortByOddEven(array1);
        ArrayUtil.sortByOddEven(array2);
        ArrayUtil.print(array1);
        ArrayUtil.print(array2);
        System.out.println();

        System.out.println("arr1: max = " + ArrayUtil.getMaximum(array1));
        System.out.println("arr1: min = " + ArrayUtil.getMinimum(array1));
        System.out.println("arr1: sum = " + ArrayUtil.getSum(array1));
        System.out.println();
        
       
        int[] reverseArr1 = ArrayUtil.reverse(array1);
        int[] reverseArr2 = ArrayUtil.reverse(array2);
        ArrayUtil.print(reverseArr1);
        ArrayUtil.print(reverseArr2);
    }
}
