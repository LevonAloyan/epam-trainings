package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            PizzeriaPalmetto pp = PizzeriaPalmetto.pizzeriaPalmettoFactory();

            scanner = new Scanner(System.in);

            pp.orderPizza(scanner);
            pp.orderPizza(scanner);

            List<PizzaBuilder.Pizza> list = pp.getPizzaList();
//            for (PizzaBuilder.Pizza pizza : list) {
//
//                System.out.println(pizza);
//            }

            Map<Long,Customer> map = pp.getCustomers();
            for (Map.Entry<Long, Customer> c: map.entrySet()) {
                System.out.println(c);
            }


            //System.out.println(pp.getCustomers());
        }finally {
            if(scanner != null){
                scanner.close();
            }
        }






    }
}
