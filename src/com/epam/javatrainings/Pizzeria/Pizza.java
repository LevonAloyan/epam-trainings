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
    private Type PizzaType;
    private int Quantity;
    private final Order _Order;
    public Pizza(Order _order) {
        _Order=_order;
        SetPizzasName();
        SetAndValidatePizzaType();
        SetAndValidateChosedIngredients();
        PrintChosedIngredients();
        SetAndValidateQuantity();
        PrintAllInfo();

    }
    public static void SetIngredientCatalogMember(Ingredient ingredient ){
       IngredientCatalog.add(ingredient);
    }
    public static void SetTypeCatalogMember(Type type){
        TypeCatalog.add(type);
    }
    public int GetCountOfUnchosedIngredients() {
        return IngredientCatalog.size()-ChosenIngredients.size();
    }
    public void SetAndValidateChosedIngredients() {
        System.out.println("Choose ingredients costumer want...");
        System.out.println("Write '1' if it will be included, '0' if not...");
        for (Ingredient ingredient: IngredientCatalog) {
            int Choose=0;
            boolean continueChoosing = false;
            while(!continueChoosing) {
                System.out.print(ingredient.GetName()+" ("+ingredient.GetPrice()+" $) : ");
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
    public void SetPizzasName() {
        System.out.print("Write pizza's name costumer want: ");
        Scanner naming = new Scanner(System.in);
        String wantedName=naming.next();
        if(ValidatePizzaName(wantedName)) {
            Name=wantedName;
        }
        else {
            Name="Customer_name_"+_Order.GetCostumerNumber();
        }
        System.out.println("Pizzas name: "+Name);
    }
    public void SetAndValidatePizzaType(){
        boolean rightchosing=false;
        while(!rightchosing) {
            System.out.print("Choose pizza's type costumer want: 1 for regular type, 0 for closed type: ");
            Scanner chosentype = new Scanner(System.in);
            int chosenType;
            try {
                chosenType = chosentype.nextInt();
                if(chosenType==1||chosenType==0) {
                    for(var type: TypeCatalog)
                    {
                        if(chosenType==1&&type.GetName()=="Regular"){
                            PizzaType=type;
                        }
                        if(chosenType==0&&type.GetName()=="Calzone"){
                            PizzaType=type;
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
        System.out.println("Pizzas type: "+PizzaType.GetName());
    }
    public void PrintChosedIngredients() {
        System.out.println("Chosed ingredients are:");
        for(var ingr: ChosenIngredients) {
            System.out.println(ingr.GetName()+" ("+ingr.GetPrice()+" $)");
        }
    }
    public void SetAndValidateQuantity() {
        int quantity;
        boolean rightChosing=false;
        while(!rightChosing) {
            System.out.print("Write quantity, up to "+_Order.AllowedQuantity()+": ");
            Scanner writedQuantity=new Scanner(System.in);
            try {
                quantity = writedQuantity.nextInt();
                if(quantity>0&&quantity<= _Order.AllowedQuantity())
                {
                    Quantity=quantity;
                    rightChosing=true;
                    System.out.println("Quantity: "+Quantity);
                }
                else
                {
                    System.out.println("Try again! Write number from (0-"+_Order.AllowedQuantity()+"].");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Try again! Write only numbers!");
            }
        }
    }
    public double Amount() {
        double amount=PizzaType.GetPrice();
        for(var ingr: ChosenIngredients) {
            amount+=ingr.GetPrice();
        }
        amount*=Quantity;
        return amount;
    }
    public void PrintAllInfo() {
        System.out.println("**************************Pizza info**************************");
        System.out.println("Name: "+Name);
        System.out.println("Type: "+PizzaType.GetName());
        PrintChosedIngredients();
        System.out.println("Quantity: "+Quantity);
        System.out.println("Payment: "+Amount()+" $ ");
        System.out.println("**************************************************************");
    }
    public boolean ValidatePizzaName(String wantedName){
        Pattern mustMatch=Pattern.compile("^[A-Za-z]{4,20}$");
        Matcher matching=mustMatch.matcher(wantedName);
        boolean isMatching=matching.matches();
        return isMatching;
    }
    public int GetQuantity()
    {
        return Quantity;
    }
    public boolean CheckAndValidateForAddingNewIngredients() {
        boolean rightchosing=false;
        boolean isAdding=false;
        while(!rightchosing) {
            System.out.print("Do you want to add ingredients? (1 - Yes) (0 - No): ");
            Scanner adding = new Scanner(System.in);
            int Adding;
            try {

                Adding =adding.nextInt();
                if(Adding==1) {
                    isAdding=true;
                    rightchosing=true;
                }
                else if(Adding==0) {
                    rightchosing=true;
                }
                else {
                    System.out.print("Try again! Write a number and only 1 or 0: ");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Try again! Write only a number!");
            }
        }
        return  isAdding;
    }
    public void AddAndValidateNewIngredient() {
        System.out.println("Choose ingredients costumer want...");
        System.out.println("Write '1' if it will be included, '0' if not...");
        for (Ingredient ingredient: IngredientCatalog) {
            if(!ChosenIngredients.contains(ingredient)) {
                int Choose = 0;
                boolean continueChoosing = false;
                while (!continueChoosing) {
                    System.out.print(ingredient.GetName() + " (" + ingredient.GetPrice() + "$) : ");
                    Scanner choose = new Scanner(System.in);
                    try {
                        Choose = choose.nextInt();
                        if (Choose == 1) {
                            ChosenIngredients.add(ingredient);
                            continueChoosing = true;
                        } else if (Choose == 0) {
                            continueChoosing = true;
                        } else {
                            System.out.println("Try again! Write 0 or 1!.");
                        }
                    } catch (Exception ex) {
                        System.out.println("Try again! Write a number!");
                    }
                }
            }
        }

    }
    public void CheckInfo(){
        System.out.println("Name    : "+Name);
        System.out.println("-------------------------------------------");
        System.out.println("Pizza Base ("+PizzaType.GetName()+") "+PizzaType.GetPrice());
        for(var ingr: ChosenIngredients) {
            System.out.println(ingr.GetName()+" ("+ingr.GetPrice()+" $)");
        }
        System.out.println("-------------------------------------------");
        System.out.println("Amount  : "+Amount()+" $");
        System.out.println("Quantity: "+Quantity);
        System.out.println("-------------------------------------------");
    }
}
