package com.epam.javatrainings.Pizzeria;


import java.util.ArrayList;
import java.util.Random;

public class Order {
    private String OrderNumber;
    private String CostumerNumber;
    private ArrayList<Pizza> PizzaList=new ArrayList<Pizza>();
    public Order() {
        int numberToSetCustomerNumber=Pizzeria.GetCostumerCount();
        CostumerNumber=String.format("%05d",numberToSetCustomerNumber);
        int numberToSetOrderNumber=new Random().nextInt(100000);
        OrderNumber=String.format("%05d",numberToSetOrderNumber);
        var pizza=new Pizza(this);
        PizzaList.add(pizza);
        while(pizza.GetCountOfUnchosedIngredients()>0&&pizza.CheckAndValidateForAddingNewIngredients())
        {
            pizza.AddAndValidateNewIngredient();
            pizza.PrintChosedIngredients();
        }
    }
    public String GetCostumerNumber() {
        return CostumerNumber;
    }
    public void AddingNewPizzaToOrder() {
        var pizza=new Pizza(this);
        PizzaList.add(pizza);
        while(pizza.GetCountOfUnchosedIngredients()>0&&pizza.CheckAndValidateForAddingNewIngredients())
        {
            pizza.AddAndValidateNewIngredient();
            pizza.PrintChosedIngredients();
        }
    }
    public double Amount() {
        double amount=0;
        for(var pizza: PizzaList)
        {
            amount+=pizza.Amount();
        }
        return amount;
    }
    public void CheckInfo() {
        System.out.println("********************************************");
        System.out.println("Order   : "+OrderNumber);
        System.out.println("Costumer: "+CostumerNumber);
        for (var pizza: PizzaList) {
            pizza.CheckInfo();
        }
        System.out.println("Amount: "+Amount()+"$ ");
        System.out.println("********************************************");
    }
    public int AllowedQuantity(){
        int alreadyOrderedQuantity=0;
        for(var pizza: PizzaList)
        {
            alreadyOrderedQuantity+=pizza.GetQuantity();
        }
        return 10-alreadyOrderedQuantity;
    }
}
