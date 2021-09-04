package javatrainings.classdecomposition;

public class DiabloPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public DiabloPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Prepparing " + name);
        tomatoPaste = ingredientFactory.addIngredientTomatoPaste();
        cheese = ingredientFactory.addIngredientCheese();
        bacon = ingredientFactory.addIngredientBacon();
        corn = ingredientFactory.addIngredientCorn();
        olives = ingredientFactory.addIngredientOlives();
    }
}
