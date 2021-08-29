package com.epam.javatrainings.Pizzeria;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //int t=30;
        //String padded = String.format("%05d",t);
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
        var RegularType = new Type("Regular", 1);
        var ClosedType= new Type("Calzone",1.5);
        Pizza.SetTypeCatalogMember(RegularType);
        Pizza.SetTypeCatalogMember(ClosedType);

        do{
            Pizzeria.MakeOrder();
        }
        while(IsWorking());
    }
    static boolean IsWorking() {
        boolean right=false;
        boolean working=false;
        while(!right) {
            System.out.print("Write 1 for next order, and 0 for exiting program: ");
            Scanner chosing = new Scanner(System.in);
            int number;
            try {
                number = chosing.nextInt();
                if (number == 1) {
                    working = true;
                    right = true;
                } else if (number == 0) {
                    working = false;
                    right = true;
                } else {
                    System.out.println("Try again! Write only 1 or 0.");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Try again! Write number and only 1 or 0.");
            }
        }
        return working;
    }
}
