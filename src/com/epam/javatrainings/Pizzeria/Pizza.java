package com.epam.javatrainings.Pizzeria;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pizza {
    private static ArrayList<Ingredient> IngredientCatalog= new ArrayList<Ingredient>();
    private static ArrayList<Type> TypeCatalog=new ArrayList<Type>();
    private String Name;
    private ArrayList<Ingredient> ChosenIngredients=new ArrayList<Ingredient>();
    private Type ChosenType;
    private int Quantity;
    private Order _Order;
    public Pizza(Order _order) {
        _Order=_order;
        ChoosePizzasName();
        ChoosePizzasType();
        ChooseIngredients();
        ShowChosedIngredients();
        ChooseQuantity();
        ShowAllInfo();

    }
    public static void SetIngredientCatalogMember(Ingredient ingredient ){
       IngredientCatalog.add(ingredient);
    }
    public static void SetTypeCatalogMember(Type type){
        TypeCatalog.add(type);
    }
    public static List<Ingredient> GetIngredientCatalog() {
        return IngredientCatalog;
    }
    public void ChooseIngredients() {
        System.out.println("Choose ingredients costumer want...");
        System.out.println("Write '1' if it will be included, '0' if not...");
        for (Ingredient ingredient: IngredientCatalog) {
            int Choose=0;
            boolean continueChoosing = false;
            while(!continueChoosing) {
                System.out.print(ingredient.GetName()+" ("+ingredient.GetPrice()+"$) : ");
                Scanner choose = new Scanner(System.in);
                try {
                    Choose = choose.nextInt();
                    if(Choose==1) {
                        ChosenIngredients.add(ingredient);
                        continueChoosing = true;
                    }
                    else if(Choose==0){
                        continueChoosing = true;
                    }
                    else{
                        System.out.println("Try again! Write 0 or 1!.");
                    }
                }
                catch(Exception ex) {
                    System.out.println("Try again! Write a number!");
                }
            }
        }
    }
    public void ChoosePizzasName() {
        System.out.print("Write pizza's name costumer want: ");
        Scanner naming = new Scanner(System.in);
        String wantedName=naming.next();
        Pattern mustMatch=Pattern.compile("^[A-Za-z]{4,20}$");
        Matcher matching=mustMatch.matcher(wantedName);
        boolean isMatching=matching.matches();
        if(isMatching) {
            Name=wantedName;
        }
        else {
            Name="Customer_name_"+_Order.GetCostumerNumber();
        }
        System.out.println("Pizzas name: "+Name);
    }
    public void ChoosePizzasType(){
        System.out.print("Choose pizza's type costumer want: 1 for regular type, 0 for closed type: ");
        boolean rightchosing=false;
        while(!rightchosing) {
            Scanner chosentype = new Scanner(System.in);
            int chosenType;
            try {
                chosenType = chosentype.nextInt();
                if(chosenType==1||chosenType==0) {
                   for(var type: TypeCatalog)
                   {
                       if(chosenType==1&&type.GetName()=="Regular"){
                           ChosenType=type;
                       }
                       if(chosenType==0&&type.GetName()=="Calzone"){
                           ChosenType=type;
                       }
                   }
                    rightchosing=true;
                }
                else {
                    System.out.print("Try again! Write only 1 or 0:");
                }
            }
            catch(Exception ex)
            {
                System.out.print("Try again! Write a number and only 1 or 0: ");
            }
        }
        System.out.println("Pizzas type: "+ChosenType.GetName());
    }
    public void ShowChosedIngredients() {
        System.out.println("Chosed ingredients are:");
        for(var ingr: ChosenIngredients)
        {
            System.out.println(ingr.GetName()+" ("+ingr.GetPrice()+"$)");

        }
    }
    public void ChooseQuantity() {
        int quantity;
        boolean rightChosing=false;
        while(!rightChosing) {
            System.out.print("Write quantity, up to 10: ");
            Scanner writedQuantity=new Scanner(System.in);
            try {
                quantity = writedQuantity.nextInt();
                if(quantity>0&&quantity<=10)
                {
                    Quantity=quantity;
                    rightChosing=true;
                    System.out.println("Quantity: "+Quantity);
                }
                else
                {
                    System.out.println("Try again! Write number from (0-10].");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Try again! Write only numbers!");
            }
        }
    }
    public double Payment() {
        double payment=ChosenType.GetPrice();
        for(var ingr: ChosenIngredients) {
            payment+=ingr.GetPrice();
        }
        payment*=Quantity;
        return payment;
    }
    public void ShowAllInfo() {
        System.out.println("**************************Pizza info**************************");
        System.out.println("Name: "+Name);
        System.out.println("Type: "+ChosenType.GetName());
        ShowChosedIngredients();
        System.out.println("Quantity: "+Quantity);
        System.out.println("Payment: "+Payment()+"$ ");
        System.out.println("**************************************************************");
    }
}
