package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.persistance.Customer;
import com.epam.javatrainings.classdecomposition.persistance.Ingredient;
import com.epam.javatrainings.classdecomposition.persistance.Pizza;
import com.epam.javatrainings.classdecomposition.persistance.PizzeriaPalmetto;
import com.epam.javatrainings.classdecomposition.service.IngredientService;
import com.epam.javatrainings.classdecomposition.service.PizzeriaPalmettoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customerOne = new Customer("Khikar", 15.5);
        Customer customerTwo = new Customer("Jone",14.7);
        Ingredient tomatoPaste = new Ingredient("Tomato paste");
        Ingredient cheese = new Ingredient("Cheese");
        Ingredient salami = new Ingredient("Salami");
        Ingredient bacon = new Ingredient("Bacon");
        Ingredient garlic = new Ingredient("Garlic");
        Ingredient olives = new Ingredient("Olives");
        Ingredient pepperoni = new Ingredient("Pepperoni");

        List<Ingredient> margaritaIngredients = IngredientService.addPizzasIngredient(tomatoPaste);
        margaritaIngredients.add(pepperoni);
        margaritaIngredients.add(garlic);
        margaritaIngredients.add(bacon);

        List<Ingredient> pepperoniOroIngredients = IngredientService.addPizzasIngredient(tomatoPaste);
        pepperoniOroIngredients.add(cheese);
        pepperoniOroIngredients.add(salami);
        pepperoniOroIngredients.add(olives);

        List<Ingredient> basePZZIngredients = IngredientService.addPizzasIngredient(tomatoPaste);
        basePZZIngredients.add(garlic);
        basePZZIngredients.add(salami);
        basePZZIngredients.add(bacon);

        Pizza margarita = new Pizza("Margarita", "closed", 2);
        margarita.setIngredients(margaritaIngredients);
        Pizza pepperoniOro = new Pizza("pepperoniOro", "closed", 3);
        pepperoniOro.setIngredients(pepperoniOroIngredients);
        Pizza basePZZ = new Pizza("BasePZZ","regular",12);
        basePZZ.setIngredients(basePZZIngredients);

        List<Pizza> customerFirstPizzas = PizzeriaPalmettoService.addPizzas(margarita);
        customerFirstPizzas.add(pepperoniOro);
        List<Pizza> customerSecondPizzas = PizzeriaPalmettoService.addPizzas(basePZZ);


        PizzeriaPalmetto pizzeriaPalmettoFirstCustomerOrder = new PizzeriaPalmetto(customerFirstPizzas);
        PizzeriaPalmettoService.printCheck(pizzeriaPalmettoFirstCustomerOrder, customerOne);

        PizzeriaPalmetto pizzeriaPalmettoSecondCustomerOrder = new PizzeriaPalmetto(customerSecondPizzas);
        PizzeriaPalmettoService.printCheck(pizzeriaPalmettoSecondCustomerOrder,customerTwo);
    }
}
