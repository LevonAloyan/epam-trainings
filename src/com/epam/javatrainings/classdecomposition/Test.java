package epam.javatrainings.classdecomposition;

public class Test {
    public static void main(String[] args) {
        Order order = new Order(10001, 7717, "base", "Pepperoni", 3);
        order.getOrderInfo();
        order.printCheck();
    }
}
