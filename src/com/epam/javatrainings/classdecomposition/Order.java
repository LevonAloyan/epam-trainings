package epam.javatrainings.classdecomposition;
import java.time.LocalTime;

public class Order {
    Menu menu;

    private final int ORDER_NUMBER_LIMIT = 99999;
    private static int orderNumber;
    private static int customerNumber;
    private String orderTimeSave;
    String pizzaName;
    int qnt;

    Order(int orderNumber, int customerNumber, String pizzaType, String pizzaName, int qnt) {
        if (pizzaName.length() < 4 && pizzaName.length() > 20) {
            this.pizzaName = "customer_name_" + orderNumber;
        } else {
            this.pizzaName = pizzaName;
        }
        this.menu = new Menu(pizzaType, pizzaName, qnt);
        if (orderNumber <= 99999) {
            this.orderNumber = orderNumber;
        }
        this.customerNumber = customerNumber;
        this.qnt = qnt;
        LocalTime orderTime = LocalTime.now();
        orderTimeSave = String.valueOf(orderTime);

    }

    public static int getOrderNumber() {
        return orderNumber;
    }

    public static int getCustomerNumber() {
        return customerNumber;
    }

    void getOrderInfo () {
        System.out.println(getOrderNumber() + " : " + getCustomerNumber() + " : " + pizzaName + " : " + qnt);

    }

    void printCheck() {
        System.out.println("********************************");
        System.out.println("Order : " + getOrderNumber() + "\n" + "Client :" + getCustomerNumber() + "\n" + "Name :" + pizzaName);
        System.out.println("--------------------------------");
        menu.getIngredients(pizzaName);
        System.out.println("--------------------------------");
        if (pizzaName.equalsIgnoreCase("diablo")) {
            System.out.println("Amount : " + menu.getPriceofDiabloPizza() + " $");
        } else if (pizzaName.equalsIgnoreCase("margarita")) {
            System.out.println("Amount : " + menu.getPriceofMargaritaPizza() + " $");
        } else if (pizzaName.equalsIgnoreCase("pepperoni")) {
            System.out.println("Amount : " + menu.getPriceofPepperoniPizza() + " $");
        }
        System.out.println("Quantity :" + qnt + "\n" + "Time :" + orderTimeSave.substring(0, 8));
        System.out.println("--------------------------------");
    }
}
