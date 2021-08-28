package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {



        PizzeriaPalmetto pp = PizzeriaPalmetto.pizzeriaPalmettoFactory();

        Scanner scanner = new Scanner(System.in);

        pp.orderPizza(scanner);
        pp.orderPizza(scanner);

        List<Pizza> list = pp.getPizzaList();
        for (Pizza pizza : list) {

            System.out.println(pizza);
        }

        scanner.close();


    }
}
