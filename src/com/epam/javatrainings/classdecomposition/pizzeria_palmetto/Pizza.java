package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class Pizza implements IngredientsCreator {
    private String name;
    private Type type;
    private int quantity;
    private Customer customer;
    private PlacingAnOrder order;
    private double costPizza;
    private Ingredients ingredients;

    public Pizza(Customer customer, String type, int quantity, PlacingAnOrder order) {
        this.customer = customer;
        this.quantity = quantity;
        this.order = order;
        this.name = customer.getNameCustomer() + "_" + order.getOrderNumber();
        this.setType(type);
        this.costPizza = quantity * this.type.getCost();

    }

    public Pizza(Customer customer, String type) {
        this.customer = customer;
        this.setType(type);
        this.costPizza = quantity * this.type.getCost();
        this.setName(customer.getNamePizza());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.isValidName(name)) {
            this.name = name;
        } else {
            this.name = customer.getNameCustomer() + "_" + order.getOrderNumber();

        }
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity <= 10) {
            this.quantity = quantity;
        } else if (quantity > 10) {
            this.quantity = 10;
        } else if (quantity < 0) {
            this.quantity = 1;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public PlacingAnOrder getOrder() {
        return order;
    }

    public void setOrder(PlacingAnOrder order) {
        this.order = order;
    }

    public double getCostPizza() {
        return costPizza;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Type getType() {
        return type;
    }

    public void setCostPizza(double costPizza) {
        this.costPizza = costPizza;
    }


    public void setType(String type) {
        if (type.equals(Type.CALZONE.getKey())) {
            this.type = Type.CALZONE;
        } else {
            this.type = Type.REGULAR;
        }
    }

    public Customer getCustomers() {
        return customer;
    }

    public boolean isValidName(String namePizza) {
        return ((namePizza != null)
                && (namePizza.matches("^[a-zA-Z]*$"))
                && (namePizza.length() >= 4)
                && namePizza.length() <= 20);
    }

    @Override
    public String toString() {
        return "[" + order.getOrderNumber() +
                ":" + customer.getNumberCustomer() +
                ":" + customer.getNameCustomer() +
                ":" + quantity + "]";
    }

    @Override
    public boolean addIngredient(String ingredient) {
        for (Ingredients ingredients : Ingredients.values()) {
            if (ingredients.getKey().equals(ingredient)) {
                ingredients.getList().add(ingredients);
                this.costPizza = this.quantity * (costPizza + ingredients.getCost());
            }
        }
        return true;
    }
}