package javatrainings.classdecomposition;

public abstract class Pizza {
     String name;

    String tomatoPaste = "Tomato paste";
    String cheese = "cheese";
    String salami = "Salami";
    String bacon = "Bacon";
    String garlic = "Garlic";
    String corn = "Corn";
    String pepperoni = "Pepperoni";
    String olives = "Olives";
    String pepper = "Pepper";

   abstract void prepare();

   void bake() {
       System.out.println("Pizza will be ready about 20 minutes");
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
