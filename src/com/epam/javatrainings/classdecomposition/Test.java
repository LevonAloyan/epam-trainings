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

        }finally {
            if(scanner != null){
                scanner.close();
            }
        }






    }
}
