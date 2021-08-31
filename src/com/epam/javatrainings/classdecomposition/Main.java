package com.epam.javatrainings.classdecomposition;

//import Pizza.Piiza;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner cs = new Scanner(System.in);
    public static ArrayList<Order> orders = new ArrayList();
    public static ArrayList<Pizza> pizzas = new ArrayList();

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
                    addpizza();
                    empty();
                    break;
                case ("2"):
                    addorder();
                    break;
                case "3":
                    showorder();
                    break;
                case "4":
                    empty();
                    break;
                case "5":
                    orders();
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
    }

    public static void addpizza() {
        Pizza pizza = new Pizza();
        System.out.print("Add pizza name- ");
        pizza.setName(cs.nextLine());
        System.out.print("Add pizza count- ");
        pizza.setCount(Integer.parseInt(cs.nextLine()));
        System.out.print("Add pizza price- ");
        pizza.setPrice(Double.parseDouble(cs.nextLine()));
        System.out.print("Add pizza Dough (CARLZONE or REGULAR)- ");
        pizza.setDough(cs.nextLine());
        pizzas.add(pizza);
        System.out.println(pizzas);
    }

    public static void addorder() {
        Order order = new Order();
        System.out.print("Add order name- ");
        order.setName(cs.nextLine());
        System.out.print("Add order time-");
        order.setTime(Integer.parseInt(cs.nextLine()));
        System.out.print("Add order count- ");
        order.setCount(Integer.parseInt(cs.nextLine()));
        System.out.println("Add order Ordernumber-");
        order.setOrdernumber((int) (Math.random() * 100000));
        orders.add(order);
        System.out.println(orders);
    }

    public static void showorder() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCount() > 10) {
                System.err.println("quantity should be less than 10");
                break;
            }
            for (int j = 0; j < pizzas.size(); j++) {
                if (pizzas.get(j).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                    System.out.print("the price of REGULAR is-");
                    System.out.println(pizzas.get(j).getPrice() + 1);
                } else if (pizzas.get(j).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                    System.out.print("the price of CARLZONE is-");
                    System.out.println(pizzas.get(j).getPrice() + 1.5);
                }
                if (pizzas.get(j).getName().length() > 4 && pizzas.get(j).getName().length() < 10) {

                } else break;

            }

        }

    }

    public static void empty() {
//        Pizza pizza = new Pizza();
        for (int i = 0; i < orders.size(); i++) {
            for (int i1 = 0; i1 < pizzas.size(); i1++) {

                if (pizzas.get(i1).getName().equals("")) {
                    pizzas.get(i1).getName().equals(orders.get(i).getOrdernumber(i));
                    System.out.println(pizzas);
                    System.out.println(pizzas.get(i1).getName() + "sssss");
                    System.out.println("barev");

                }
            }
        }
    }

    public static void orders() {
        double pricee = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).getName().equals(List.BACON2$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 2 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.BACON2$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 2 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.CHESE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.CHESE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.SALAMI15$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 15 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.SALAMI15$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 15 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.TOMATOPASTE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.TOMATOPASTE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.GARLIC3$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 3 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.GARLIC3$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 3 + 1.5;
                System.out.println(pricee);
            }

            if (pizzas.get(i).getName().equals(List.CORN4$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 4 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.CORN4$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 4 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.PEPPERONI5$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 5 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.PEPPERONI5$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 5+ 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getName().equals(List.OLIVES6$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 6+ 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getName().equals(List.OLIVES6$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 6 + 1.5;
                System.out.println(pricee);
            }
        }
    }
}

