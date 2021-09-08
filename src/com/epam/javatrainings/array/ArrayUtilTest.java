package com.epam.javatrainings.array;

public class ArrayUtilTest {

        public static void main(String[] args) {
                int[] array = {1, 6, 8, 3, 5, 4, 10, 7};

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