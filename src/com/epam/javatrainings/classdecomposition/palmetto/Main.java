package com.epam.javatrainings.classdecomposition.palmetto;

import com.epam.javatrainings.classdecomposition.palmetto.model.Customer;
import com.epam.javatrainings.classdecomposition.palmetto.model.Ingredients.*;
import com.epam.javatrainings.classdecomposition.palmetto.model.Management;
import com.epam.javatrainings.classdecomposition.palmetto.model.Order;
import com.epam.javatrainings.classdecomposition.palmetto.model.Pizza;

public class Main {

    public static void main(String[] args) {
        Management service =new Management();

        Bacon bacon = new Bacon();
        Cheese cheese=new Cheese();
        Corn corn=new Corn();
        Garlic garlic=new Garlic();
        Olives olives=new Olives();
        Pepperoni pepperoni=new Pepperoni();
        Salami salami =new Salami();
        Tomato tomato=new Tomato();

        Customer arsen = new Customer(3033, "Arsen", 1000);
        Customer vardanDza= new Customer(1300, "VARDAN Dza",2500);

        Pizza pizza1 = new Pizza( "Pepperoni",true);
        pizza1.addIngredient (cheese);
        pizza1.addIngredient(pepperoni);
        Pizza pizza2 = new Pizza( "Margarita1",false);
        pizza1.addIngredient (olives);
        pizza1.addIngredient(tomato);

        Order order1 = service.createOrder (arsen);
        order1.addPizza (pizza1,2);
        order1.addPizza(pizza2,1);

        Order order2 = service.createOrder(vardanDza);
        order2.addPizza (pizza2,1);

        Pizza pizzaTest1= service.createPizza (vardanDza,true);
        Pizza pizzaTnakan = service.createPizza ("Tnakan", false);
        pizzaTnakan.addIngredient (bacon);
        pizzaTnakan.addIngredient (cheese);
        pizzaTnakan.addIngredient (corn);
        pizzaTnakan.addIngredient (garlic);
        pizzaTnakan.addIngredient (olives);
        pizzaTnakan.addIngredient (pepperoni);
        pizzaTnakan.addIngredient (salami);
        pizzaTnakan.addIngredient (tomato);

       float cost= service.addPizza (order2,pizzaTnakan,3);
        service.addOrder (order2);

        service.showOrders ();
    }
}
