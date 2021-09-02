package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int [] array = {1,2,12,-56,12,98,56,48};
        int [] array2 = {-1001,400,-999,7,60,60,3,500,500,500,5};
        int [] emptyArray = new int[0];
        int [] oneElementArray = {100000000};

        try {
            int min = ArrayUtil.getMinimum(array2);
            int max = ArrayUtil.getMaximum(array2);
            int sum = ArrayUtil.getSum(array2);
            System.out.println("max : " + max + "\n" + "min : " + min + "\n" + "sum : " + sum + "\n");
            ArrayUtil.print(ArrayUtil.reverse(array2));

        } catch (EmptyArrayException e) {
            e.printStackTrace();
        }

        ArrayUtil.sortByOddAndEven(array2);
        ArrayUtil.print(array2);

    }
}
