package com.epam.javatrainings.classdecomposition;

public class OrderPizza {
    private final Pizza pizza;
    private final int quantity;
    private final String name;

    public OrderPizza(Pizza pizza, int quantity, String name) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.name = name;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double calculatePrice() {
        return pizza.calculatePrice() * quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(("--------------------------------\n"));
        sb.append("Pizza: ").append("'").append(name).append("'").append("\n");
        sb.append(pizza.getType().getName()).append(": ").append(pizza.getType().getPrice()).append("$\n");
        for(Ingredient ingredient : pizza.getIngredients()) {
            sb.append(ingredient.getName()).append(": ").append(ingredient.getPrice()).append("$\n");
        }
        sb.append(("--------------------------------\n"));
        sb.append("Price: ").append(pizza.calculatePrice()).append("\n");
        sb.append("Quantity: ").append(quantity).append("\n");
        return sb.toString();
    }
}
