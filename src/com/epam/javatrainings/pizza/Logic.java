package com.epam.javatrainings.pizza;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {

    private static final Scanner scanner = new Scanner(System.in);
    private static double price = 0.0;
    private static final Data data = new Data();
    private static int count = 0;


    public void start() {
        while (true) {

            data.type();

            int type = scanner.nextInt();
            if (type == 1) {
                price += 1;
            } else if (type == 2) {
                price += 1.5;
            }
            data.menu();
            String pizza = scanner.next();
            String regex = "^[a-zA-Z]{3,20}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pizza);
            boolean b = matcher.matches();
            if (b && data.pizza().containsKey(pizza)) {
                price += data.pizza().get(pizza).getPrice();
                System.out.println("Would you like extra ingredients ? yes or no");
                String ingredient = scanner.next();
                if ((ingredient.equals("yes"))) {
                    boolean t = false;
                    while (!t) {
                        count++; // no more than 7 ingredient to add
                        if (count != 8) {
                            data.printIngredient();
                            String choice = scanner.next();
                            scanner.nextLine();
                            if (data.ingredient().containsKey(choice)) {
                                price += data.ingredient().get(choice);
                            } else {
                                System.out.println("Please enter the name correctly!");
                            }
                            System.out.println();
                            if (count != 7) {
                                System.out.println("Do you want to add more ingredients? yes or no");
                                String more = scanner.next();
                                t = !more.equals("yes");
                            }
                        } else {
                            t = true;
                        }
                    }
                }
                System.out.println("Enter the quantity!");
                int quantity = scanner.nextInt();
                price *= quantity;
                System.out.println("Total price: " + price);
                Pizza pizza1 = new Pizza(quantity, pizza);
                System.out.println(pizza1.toString());
            } else {
                Pizza pizza1 = new Pizza(1, "custumer_name_" + (Pizza.getCustomerNumber() + 1));
                System.out.println(pizza1.toString());
            }
            for (int i = 0; i < 5; i++) {
                System.out.println();
            }
            price = 0.0;
            count = 0;
        }
    }

}
