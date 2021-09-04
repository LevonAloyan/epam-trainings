package javatrainings.classdecomposition;

public class PepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    @Override
    void prepare() {
        System.out.println("Prepparing " + name);
        tomatoPaste = ingredientFactory.addIngredientTomatoPaste();
        cheese = ingredientFactory.addIngredientCheese();
        pepperoni = ingredientFactory.addIngredientPepperoni();
        salami = ingredientFactory.addIngredientSalami();
    }
}
