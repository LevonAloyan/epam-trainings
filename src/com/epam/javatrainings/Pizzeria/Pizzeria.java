package com.epam.javatrainings.Pizzeria;

import java.util.Scanner;

public class Pizzeria {
    public static String Name="Palmetto";
    private static int CustomerCount=0;
    public static void MakeOrder() {
        var order=new Order();
        while(CheckingIsThereAnyAdding()){
            order.AddingNewPizzaToOrder();
        }
        order.ShowInfo();
    }
    public static int GetCostumerCount() {
       return ++CustomerCount;
    }
    public static boolean CheckingIsThereAnyAdding() {
       boolean rightchosing=false;
       boolean isadding=false;
       while(!rightchosing) {
          System.out.print("Do costumer want other pizza too? (1-Yes) (0-No): ");
          Scanner chosing = new Scanner(System.in);
          int number;
          try {
             number = chosing.nextInt();
             if (number == 1) {
                isadding = true;
                rightchosing = true;
             } else if (number == 0) {
                isadding = false;
                rightchosing = true;
             } else {
                System.out.println("Try again! Write only 1 or 0.");
             }
          }
          catch (Exception ex)
          {
             System.out.println("Try again! Write number and only 1 or 0.");
          }
       }
       return isadding;
    }
    public static void AddingToOrder(Order order)
    {
        order.AddingNewPizzaToOrder();
    }

}
