package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.*;

public class PalmettoPizzeriaCashDesk {
    static public class Order{
         public class Pizza {
            static private Integer pizzaIdGenerator;
            final static int MAX_INGREDIENTS=5;
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
                pizzaIdGenerator =0;
            }//init ingredients list with costs
            private Integer pizza_id;//pizza id
            private String name;// pizza nameprivate Integer quantity;
            private Type type;// pizza type Regular or Cazoline
            private ArrayList<String> actual_ingredients;//ingredients that the customer chosen
            private Integer quantity;
             private Pizza()// pizza constructor made private to let make pizzas only with function choose pizza
            {
                actual_ingredients=new ArrayList<String>();
                pizzaIdGenerator++;
                pizza_id= pizzaIdGenerator;
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
                if(actual_ingredients.size()==MAX_INGREDIENTS){
                    System.out.println("No place for ingredients");
                    return;
                }
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
            Double cost=pizza_types.get(i).type==Type.REGULAR?1.0:1.5;
            for (String a :
            pizza_types.get(i).actual_ingredients) {
                cost+= Pizza.ingredients.get(a);
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
            new_pizza.setName(answer);
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
                new_pizza.quantity=q;
            }
            catch (InputMismatchException a)
            {
                System.out.println("You didn't enter a number so ill take 1");
                new_pizza.quantity=1;
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
            System.out.println("["+orderCodeGenerator()+":"+customer+":"+pizza_types.get(pizzaTypes-1).getName()+":"+pizza_types.get(pizzaTypes-1).quantity+"]");
        }
        public void seeMyPizza(int a) throws ArrayIndexOutOfBoundsException//pizza show with argument trows exception
        {
            if(a<0||a> pizzaTypes)
                throw new ArrayIndexOutOfBoundsException();
            System.out.println("["+orderCodeGenerator()+":"+customer+":"+pizza_types.get(a).getName()+":"+pizza_types.get(a).quantity+"]");
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
                System.out.println("Name: "+a.name);
                System.out.println("--------------------------------");
                String base=a.type==Type.REGULAR?"Pizza base Regular 1.0 $":"Pizza base Calzone 1.5 $";
                System.out.println(base);
                for (var ingredient :
                       a.actual_ingredients ) {
                    System.out.println(ingredient + " " + Pizza.ingredients.get(ingredient)+"$");
                }
                System.out.println("--------------------------------");
                System.out.println("Amount: "+String.format("%,.2f", cost(iter)));
                total+=cost(iter)* a.quantity;
                iter++;
                System.out.println("Quantity: "+a.quantity);
            }
            System.out.println("--------------------------------");
            System.out.println("Total Amount :"+String.format("%,.2f", total));
            System.out.println("********************************");
        }
    }

    private ArrayList<Order> order_list;
    PalmettoPizzeriaCashDesk(){
        order_list=new ArrayList<>();
    }
    public void addOrder(String name){
        order_list.add(new Order(name));
    }
    public Order getOrder(int i) throws ArrayIndexOutOfBoundsException
    {
        return order_list.get(i);
    }
}
