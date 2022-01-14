package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 6, 8, 1, 3, 5};
        System.out.println("----------Initial array----------");
        ArrayUtil.print(array);
        System.out.println("----------Array after sorting----------");
        ArrayUtil.sortByOddAndEven(array);
        ArrayUtil.print(array);
        System.out.println("----------Minimum element of array----------");
        System.out.println(ArrayUtil.getMinimum(array));
        System.out.println("----------Maximum element of array----------");
        System.out.println(ArrayUtil.getMaximum(array));
        System.out.println("----------Sum of elements of array----------");
        System.out.println(ArrayUtil.getSum(array));
        System.out.println("----------Array after reverse----------");
        ArrayUtil.reverse(array);
        ArrayUtil.print(array);
    }
}
