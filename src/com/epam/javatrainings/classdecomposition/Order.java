package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.*;

public class Order{


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
    private ArrayList<Pizza> pizza_types;//pizzas to build
    private Integer pizzaTypes;
    private String customer;//customer name
    private LocalTime time;
    public Order(String name)//constructor with customer name
    {
        time=LocalTime.now();
        pizza_types=new ArrayList<>();
        customer=name;
        order_count++;
        id=order_count;
        pizzaTypes=0;
    }
    private Double cost(int i)//cost calculate
    {
        Double cost=pizza_types.get(i).getType()==Type.REGULAR?1.0:1.5;
        for (String a :
                pizza_types.get(i).getActual_ingredients()) {
            cost+= Pizza.getIngredients().get(a);
        }
        return cost;
    }
    public void choosePizza()//function to choose and build pizza
    {
        pizzaTypes++;
        Pizza new_pizza=new Pizza();
        Scanner sc=new Scanner(System.in);
        System.out.println("What do you want to name you pizza?");//works correct for any input
        String answer=sc.nextLine();
        new_pizza.setName(answer,customer);
        System.out.println("Chose pizza type regular or closed (Calzone) ");//forgot that java has no goto so didnt organize the invalid input handling
        answer=sc.nextLine();
        answer=answer.toUpperCase(Locale.ROOT);
        switch (answer)
        {
            case "REGULAR" :
                new_pizza.setType(Type.REGULAR);
                break;
            case "CLOSED" :
                new_pizza.setType(Type.CALZONE);
                break;
            case "CALZONE" :
                new_pizza.setType(Type.CALZONE);
                break;
            default:
                System.out.println("I dont understand ill make regular");
                new_pizza.setType(Type.REGULAR);
        }
        System.out.println("--------------------------\nChose ingredients \nEnter 'skip' to skip\n--------------------------");//can choose as mach ingredients as you want
        Pizza.showIngredientList();
        answer=sc.nextLine();
        while(true)
        {
            if(answer.equals("skip"))
                break;
            new_pizza.addIngredient(answer);
            answer=sc.nextLine();

        }
        System.out.println("Enter quantity");
        try {
            Integer q = sc.nextInt();
            new_pizza.setQuantity(q);
        }
        catch (InputMismatchException a)
        {
            System.out.println("You didn't enter a number so ill take 1");
            new_pizza.setQuantity(1);
        }

        pizza_types.add(new_pizza);
        System.out.println("your pizza order accepted");
        System.out.println("Do you want to add another pizza? Y/N");
        Scanner sc2=new Scanner(System.in);
        answer= sc2.nextLine();
        answer=answer.toUpperCase(Locale.ROOT);
        switch (answer)
        {
            case "Y":
                choosePizza();
                break;
            case "N":
                return;
            default:
                System.out.println("I ll understand it as NO");
        }
    }
    public void seeMyPizza()//pizza show
    {
        System.out.println("["+orderCodeGenerator()+":"+customer+":"+pizza_types.get(pizzaTypes-1).getName()+":"+pizza_types.get(pizzaTypes-1).getQuantity()+"]");
    }
    public void seeMyPizza(int a) throws ArrayIndexOutOfBoundsException//pizza show with argument trows exception
    {
        if(a<0||a> pizzaTypes)
            throw new ArrayIndexOutOfBoundsException();
        System.out.println("["+orderCodeGenerator()+":"+customer+":"+pizza_types.get(a).getName()+":"+pizza_types.get(a).getQuantity()+"]");
    }
    public void printCheck()
    {
        double total=0;
        System.out.println("********************************");
        System.out.println("Time :"+time);
        System.out.println("********************************");
        System.out.println("Order: "+orderCodeGenerator());
        System.out.println("Client: "+customer);
        int iter=0;
        for (var a:
                pizza_types) {
            System.out.println("Name: "+a.getName());
            System.out.println("--------------------------------");
            String base=a.getType()==Type.REGULAR?"Pizza base Regular 1.0 $":"Pizza base Calzone 1.5 $";
            System.out.println(base);
            for (var ingredient :
                    a.getActual_ingredients() ) {
                System.out.println(ingredient + " " + Pizza.getIngredients().get(ingredient)+"$");
            }
            System.out.println("--------------------------------");
            System.out.println("Amount: "+String.format("%,.2f", cost(iter)));
            total+=cost(iter)* a.getQuantity();
            iter++;
            System.out.println("Quantity: "+a.getQuantity());
        }
        System.out.println("--------------------------------");
        System.out.println("Total Amount :"+String.format("%,.2f", total));
        System.out.println("********************************");
    }
}
