package com.epam.javatrainings.Pizzeria;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pizzeria.SetIngredientCatalog();
        Pizzeria.SetTypeCatalog();
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
