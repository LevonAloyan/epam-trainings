package javatrainings.classdecomposition;

public class MargaritaPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public MargaritaPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
//    Margarita pizza with the following ingredients: tomato paste, pepper, garlic, and bacon.
    @Override
    void prepare() {
        System.out.println("Prepparing " + name);
        tomatoPaste = ingredientFactory.addIngredientTomatoPaste();
        pepper = ingredientFactory.addIngredientPepper();
        garlic = ingredientFactory.addIngredientGarlic();
        bacon = ingredientFactory.addIngredientBacon();
    }
}
