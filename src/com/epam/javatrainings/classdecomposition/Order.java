package com.epam.javatrainings.classdecomposition;

//import java.sql.Time;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Date time;
    private int ordernumber;
    private String name;
    private int count;



    public Order(Date time, int ordernumber, String name, int count) {
        this.time = time;
        this.ordernumber = ordernumber;
        this.name = name;
        this.count = count;

    }

    public Order() {

    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getOrdernumber(int i) {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", ordernumber=" + ordernumber +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }


    public static Scanner cs = new Scanner(System.in);
    //    public static ArrayList<Order> orders = new ArrayList();
//    public static ArrayList<Pizza> pizzas = new ArrayList();
    public static List<Pizza> pizzas = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    public static void addpizza() {
        Pizza pizza = new Pizza();
        Order order=new Order();
        System.out.println(order);
        ArrayList<String> ingredient = new ArrayList();
        System.out.print("Add pizza name- ");
        pizza.setName(cs.nextLine());
        System.out.print("Add pizza count- ");
        pizza.getClient();
        System.out.print("Add pizza price- ");
        pizza.setPrice(Double.parseDouble(cs.nextLine()));
        System.out.print("Add pizza Dough (CARLZONE or REGULAR)- ");
        pizza.setDough(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        ingredient.add(cs.nextLine());
        System.out.println("add pizza ingredient-");
        pizza.setIngredient(ingredient);
        pizza.setOrder(order);
        pizzas.add(pizza);
        System.out.println(pizzas);
    }

    public static void addorder() {
        Order order = new Order();
        Date date=new Date();
        System.out.print("Add order name- ");
        order.setName(cs.nextLine());
        System.out.print("Add order time-");
        order.setTime(date);
        System.out.print("Add order count- ");
        order.setCount(Integer.parseInt(cs.nextLine()));
        System.out.println("Add order Ordernumber-");
        order.setOrdernumber((int) (Math.random() * 100000));
        orders.add(order);
        System.out.println(orders);
    }

    public static void conditionorder() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCount() > 10) {
                System.err.println("quantity should be less than 10");
                break;
            }
        }
        for (int j = 0; j < pizzas.size(); j++) {
            if (pizzas.get(j).getName().length() > 4 && pizzas.get(j).getName().length() < 10) {

            } else System.out.println("error");
            break;
        }

    }


    public static void updatename() {
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

    public static void showprice() {
        double pricee = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.BACON2$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 2 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.BACON2$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 2 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.CHESE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.CHESE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.SALAMI15$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 15 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.SALAMI15$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 15 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.TOMATOPASTE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.TOMATOPASTE1$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 1 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.GARLIC3$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 3 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.GARLIC3$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 3 + 1.5;
                System.out.println(pricee);
            }

            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.CORN4$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 4 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.CORN4$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 4 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.PEPPERONI5$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 5 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.PEPPERONI5$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 5 + 1.5;
                System.out.println(pricee);
            }
            if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.OLIVES6$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.REGULAR.name())) {
                pricee = pizzas.get(i).getPrice() + 6 + 1;
                System.out.println(pricee);
            } else if (pizzas.get(i).getIngredient().get(i).equals(Listingredients.OLIVES6$.name()) && pizzas.get(i).getDough().equals(Pizza.Piiza.CARLZONE.name())) {
                pricee = pizzas.get(i).getPrice() + 6 + 1.5;
                System.out.println(pricee);
            }
        }
    }

    public static void addIngredient() {
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).getIngredient().get(i).equals("")) {
                System.out.println("not full Ingredient");
            } else System.out.println("full");
        }
        for (int i1 = 0; i1 < pizzas.size(); i1++) {
            System.out.println(pizzas.get(i1).getIngredient().get(i1));
//            i1++;
            for (int i2 = i1; i2 < pizzas.size(); i2++) {
                System.out.println("barev");
                System.out.println(pizzas.get(i2).getIngredient().get(i2));
                if (pizzas.get(i1).getIngredient().get(i1).equals(pizzas.get(i2).getIngredient().get(i2))) {
                    System.out.println("ripit now");
                } else System.out.println("ssss");
            }
        }
        Pizza pizza = new Pizza();
        ArrayList<String> margarita = new ArrayList<>();
        pizza.setName("Margarita");
        pizza.getClient();
        pizza.setPrice(1500);
        pizza.setDough(Pizza.Piiza.REGULAR.name());
        margarita.add("tomato");
        margarita.add("paste");
        margarita.add("pepper");
        margarita.add("garlic");
        margarita.add("bacon");
        pizza.setIngredient(margarita);
        pizzas.add(pizza);
        System.out.println(pizzas);
    }


    public static void printCheck() {
        System.out.println("***************");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order:"+orders.get(i).getOrdernumber(i));
            System.out.println("Quantity:"+orders.get(i).getCount());
            System.out.println("Time:"+orders.get(i).getTime());

        }
        int mount=0;
        for (int i = 0; i < pizzas.size(); i++) {
//            System.out.println("Order"+pizzas.get(i).getOrder().getOrdernumber(i));
            System.out.println("Client:"+pizzas.get(i).getClient());
            System.out.println("Name:"+pizzas.get(i).getName());
            System.out.println("------------------");
            System.out.println("Listingredients:"+pizzas.get(i).getIngredient());
            System.out.println("------------------");
            System.out.println("Amount:"+pizzas.get(i).getPrice()+"$");
//            int mount=0;
            mount+=pizzas.get(i).getPrice();
        }
        System.out.println("Total Amount"+mount+"$");
    }
}