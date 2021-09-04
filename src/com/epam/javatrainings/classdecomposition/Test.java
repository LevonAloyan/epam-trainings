package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            PizzeriaPalmetto pp = PizzeriaPalmetto.pizzeriaPalmettoFactory(scanner);
            pp.orderPizza();
            pp.showPizzaPalmettoDatabase();

        }finally {
            if(scanner != null){
                scanner.close();
            }
        }






    }
}
