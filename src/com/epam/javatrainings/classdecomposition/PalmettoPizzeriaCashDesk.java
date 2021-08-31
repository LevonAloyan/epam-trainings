package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalmettoPizzeriaCashDesk {
    static public class Order{
         public class Pizza {
            static private Integer pizzaCount;
            static private HashMap<String, Double> ingredients;//list of ingredients can be extended
            static {
                ingredients=new HashMap<String,Double>();
                ingredients.put("Tomato paste", 1.0);
                ingredients.put("Cheese", 1.0);
                ingredients.put("Salami", 1.5);
                ingredients.put("Bacon", 1.2);
                ingredients.put("Garlic", 0.3);
                ingredients.put("Corn", 0.7);
                ingredients.put("Pepperoni", 0.6);
                ingredients.put("Olives", 0.5);
                pizzaCount=0;
            }//init ingredients list with costs
            private Integer pizza_id;//pizza id
            private String name;// pizza name
            private Type type;// pizza type Regular or Cazoline
            private ArrayList<String> actual_ingredients;//ingredients that the customer chosen
            private Pizza()// pizza constructor made private to let make pizzas only with function choose pizza
            {
                actual_ingredients=new ArrayList<String>();
                pizzaCount++;
                pizza_id=pizzaCount;
            }
            public String getName() {
                return name;
            }//get pizza Name

            public void setName(String name) {
                if(name.length()<4||name.length()>20)
                {
                    this.name=customer+"_"+pizza_id;
                }else
                    this.name = name;
            }//set pizza name logic

            public Type getType() {
                return type;
            }

            public void setType(Type type) {
                this.type = type;
            }
            public void addIngredient(String i)//add ingredients to pizza
            {
                if(ingredients.containsKey(i))
                    actual_ingredients.add(i);
                else
                    System.out.println("no such ingredient");
            }
            static public  void showIngredientList()//show ingredients list
            {
                ingredients.entrySet().forEach(item -> {
                    System.out.println(item.getKey() + " " + item.getValue()+"$");
                });
            }
        }

        static private int order_count;//id generator and its init
        static{
            order_count=0;
        }
        private int id;//instance id
        private  String orderCodeGenerator(){
            String identifier=Integer.toString(id);
            while(identifier.length()!=5)
            {
                identifier="0"+identifier;
            }
            return identifier;
        }//mo make "XXXXXX" style id
        private Pizza pizza;//pizza to build
        private Integer pizzaCount;//quantity
        private String customer;//customer name
        public Order(String name)//constructor with customer name
        {
            customer=name;
            order_count++;
            id=order_count;
        }
        public Double cost()//cost calculate
        {
            Double cost=pizza.type==Type.REGULAR?1.0:1.5;
            for (String a :
            pizza.actual_ingredients) {
                cost+= pizza.ingredients.get(a);
            }
            return cost;
        }
        public void choosePizza()//function to choose and build pizza
        {
            pizza=new Pizza();
            Scanner sc=new Scanner(System.in);
            System.out.println("What do you want to name you pizza?");//works correct for any input
            String answer=sc.nextLine();
            pizza.setName(answer);
            System.out.println("Chose pizza type regular or closed (Calzone) ");//forgot that java has no goto so didnt organize the invalid input handling
            answer=sc.nextLine();
            switch (answer)
            {
                case "regular" :
                    pizza.setType(Type.REGULAR);
                    break;
                case "closed" :
                    pizza.setType(Type.CALZONE);
                    break;
                case "Calzone" :
                    pizza.setType(Type.CALZONE);
                    break;
                default:
                    System.out.println("I dont understand ill make regular");
                    pizza.setType(Type.REGULAR);
            }
            System.out.println("Chose ingredients  /n Enter skip to skip");//can choose as much ingredients as you want
            Pizza.showIngredientList();
            answer=sc.nextLine();
            while(true)
            {
                pizza.addIngredient(answer);
                answer=sc.nextLine();
                if(answer.equals("skip"))
                    break;
            }
            System.out.println("Enter quantity");
            Integer q=sc.nextInt();
            pizzaCount=q;
            System.out.println("your pizza order accepted");
        }
        public void seeMyPizza()//order showing
        {
            System.out.println("["+orderCodeGenerator()+":"+customer+":"+pizza.getName()+":"+pizzaCount+"]");
        }
    }

}
