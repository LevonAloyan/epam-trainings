package com.epam.javatrainings.classdecomposition;

//import Pizza.Piiza;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner cs = new Scanner(System.in);
//    public static ArrayList<Order> orders = new ArrayList();
//    public static ArrayList<Pizza> pizzas = new ArrayList();

    public static void main(String[] args) {
        boolean ok = true;
        while (ok) {
            print();
            String x = cs.nextLine();
            switch (x) {
                case ("0"):
                    ok = false;
                    break;
                case ("1"):
//                    addpizza();
                    Order.addpizza();
                    break;
                case ("2"):
//                    addorder();
                    Order.addorder();
                    break;
                case "3":
//                    conditionorder();
                    Order.conditionorder();
                    break;
                case "4":
//                    updatename();
                    Order.updatename();
                    break;
                case "5":
                    Order.showprice();
//                    showprice();
                    break;
                case "6":
                    Order.addIngredient();
//                    addIngredient();
                    break;
                case "7":
                    Order.printCheck();
                    break;
                default:
                    System.err.println("Error");
                    break;

            }
        }


    }

    public static void print() {
        System.out.println("exit-0");
        System.out.println("addorder-1");
        System.out.println("addpizza-2");
        System.out.println("showorder-3");
        System.out.println("empty-4");
        System.out.println("orders-5");
        System.out.println("addIngredient-6");
    }


    }


