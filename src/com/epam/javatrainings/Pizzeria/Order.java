package com.epam.javatrainings.Pizzeria;


import java.util.ArrayList;
import java.util.Random;

public class Order {
    private String OrderNumber;
    private int CostumerNumber;
    private ArrayList<Pizza> PizzaList=new ArrayList<Pizza>();
    public Order() {
        CostumerNumber=Pizzeria.GetCostumerCount();
        int Number=new Random().nextInt(100000);
        OrderNumber=String.format("%05d",Number);
        var pizza=new Pizza(this);
        PizzaList.add(pizza);
    }
    public int GetCostumerNumber()
    {
        return CostumerNumber;
    }
    public void AddingNewPizzaToOrder() {
        var pizza=new Pizza(this);
        PizzaList.add(pizza);
    }
    public double Payment() {
        double payment=0;
        for(var pizza: PizzaList)
        {
            payment+=pizza.Payment();
        }
        return payment;
    }
    public void ShowInfo() {
        System.out.println("**************************Order info**************************");
        System.out.println("Order number: "+OrderNumber);
        System.out.println("Costumer number: "+CostumerNumber);
        System.out.println("Payment: "+Payment());
        System.out.println("**************************************************************");
    }
}
