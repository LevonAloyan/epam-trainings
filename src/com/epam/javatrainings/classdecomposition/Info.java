package javatrainings.classdecomposition;

public class Info{
    private Order order;

    public Info(Order order) {
        this.order = order;
    }

    public void orderInfo() {
        System.out.println("[ " + order.getOrderNumber() + " : " + order.getCustomerNumber() + ": " + order.getPizzaName() + ": " + order.getQuantity() + "]");
    }

    public  void printCheck() {
        System.out.println("*************************");
        System.out.println(order.getOrderNumber());
        System.out.println(order.getCustomerNumber());
        System.out.println(order.getPizzaName());
        System.out.println(order.orderTime);
    }

}
