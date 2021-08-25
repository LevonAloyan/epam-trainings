package com.epam.javatrainings.array;

public class ArrayUtilTest {

    public static void main(String[] args) {
        int[] array = new int[]{1,5,2,6,7,3,4};
        ArrayUtil arrayUtil = new ArrayUtil();

        //print() method
        System.out.println("_________________________ Print Array _______________________");
        System.out.print("                     ");
        ArrayUtil.print(array);
        System.out.println("\n_____________________________________________________________");


        //sortByOddAndEven() method
        System.out.println("______ Sorts the array elements by odd and even number ______");
        System.out.println("                  Array before sorted");
        System.out.print("                     ");
        ArrayUtil.print(array);
        System.out.println();
        System.out.println("                      Sorted array");
        System.out.print("                     ");
        arrayUtil.sortByOddAndEven(array);
        System.out.println("\n_____________________________________________________________");

        //getMaximum() method
        System.out.println("_________________ Get array maximum element _________________");
        System.out.print("                 Array maximum element is - " + ArrayUtil.getMaximum(array));
        System.out.println("\n_____________________________________________________________");

        //getMinimum() method
        System.out.println("_________________ Get array minimum element _________________");
        System.out.print("                 Array maximum element is - " + ArrayUtil.getMinimum(array));
        System.out.println("\n_____________________________________________________________");

        //getSum() method
        System.out.println("__________________ Array all elements sum ___________________");
        System.out.print("                 Array all elements sum is - " + ArrayUtil.getSum(array));
        System.out.println("\n_____________________________________________________________");

        //reverse() method
        System.out.println("_______________________ Reverse Array _______________________");
        System.out.println("                  Array before reversed");
        System.out.print("                     ");
        ArrayUtil.print(array);
        System.out.println("\n                      Reversed array");
        System.out.print("                     ");
        ArrayUtil.print(ArrayUtil.reverse(array));
        System.out.println("\n_____________________________________________________________");
    }
}
