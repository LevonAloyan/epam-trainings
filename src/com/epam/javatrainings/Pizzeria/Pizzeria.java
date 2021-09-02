package com.epam.javatrainings.Pizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {
    public static String Name="Palmetto";
    private static int CostumerCount=0;
    private static ArrayList<Order> OrderHistory=new ArrayList<Order>();
    public static void MakeOrder() {
        var order=new Order();
        OrderHistory.add(order);
        while(order.AllowedQuantity()>=1&&CheckingIsThereAnyAdding()){
            order.AddingNewPizzaToOrder();
        }
        order.CheckInfo();
    }
    public static int GetCostumerCount() {
       return ++CostumerCount;
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
    public static void SetIngredientCatalog() {
        var Tomato_paste=new Ingredient("Tomato paste", 1);
        var Cheese=new Ingredient("Cheese", 1);
        var Salami=new Ingredient("Salami", 1.5);
        var Bacon=new Ingredient("Bacon", 1.2);
        var Garlic=new Ingredient("Garlic", 0.3);
        var Corn=new Ingredient("Corn", 0.7);
        var Pepperoni=new Ingredient("Pepperoni", 0.6);
        Pizza.SetIngredientCatalogMember(Tomato_paste);
        Pizza.SetIngredientCatalogMember(Cheese);
        Pizza.SetIngredientCatalogMember(Salami);
        Pizza.SetIngredientCatalogMember(Bacon);
        Pizza.SetIngredientCatalogMember(Garlic);
        Pizza.SetIngredientCatalogMember(Corn);
        Pizza.SetIngredientCatalogMember(Pepperoni);
    }
    public static void SetTypeCatalog(){
        var RegularType = new Type("Regular", 1);
        var ClosedType= new Type("Calzone",1.5);
        Pizza.SetTypeCatalogMember(RegularType);
        Pizza.SetTypeCatalogMember(ClosedType);
    }
}
