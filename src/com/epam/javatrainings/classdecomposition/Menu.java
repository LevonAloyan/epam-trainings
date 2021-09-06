package epam.javatrainings.classdecomposition;

public class Menu {
//    Pizza pizza;
    String name;
    String type;
    int qnt;


    DiabloPizza diablo;
    MargaritaPizza margarita;
    PepperoniPizza pepperoni;

   private double pepperIngrPrc = 0.2;
   private double tomatopasteIngrPrc = 1;
   private double cheeseIngrPrc = 1;
   private double salamiIngrPrc = 1.5;
   private double baconIngrPrc = 1.2;
   private double garlicIngrPrc = 0.3;
   private double cornIngrPrc = 0.7;
   private double pepperoniIngrPrc = 0.6;
   private double olivesIngrPrc = 0.5;
   private double priceofPizza;
   private double priceofDiabloPizza;
   private double priceofMargaritaPizza;
   private double priceofPepperoniPizza;

    Menu(String type, String name, int qnt) {
        this.type = type;
        this.name = name;
        this.qnt = qnt;
        if (name.equalsIgnoreCase("diablo") && type.equalsIgnoreCase("calzone")) {
            this.diablo = new DiabloPizza();
            this.priceofDiabloPizza = diablo.getBacon() * baconIngrPrc + diablo.getCheese() * cheeseIngrPrc + diablo.getOlives() * olivesIngrPrc + diablo.getTomatoPaste() * tomatopasteIngrPrc;
            this.priceofPizza = priceofDiabloPizza * qnt + 1.5;
        } else {
            this.diablo = new DiabloPizza();
            this.priceofDiabloPizza = diablo.getBacon() * baconIngrPrc + diablo.getCheese() * cheeseIngrPrc + diablo.getOlives() * olivesIngrPrc + diablo.getTomatoPaste() * tomatopasteIngrPrc;
            priceofPizza = priceofDiabloPizza * qnt + 1;
        }
        if (name.equalsIgnoreCase("margarita") && type.equalsIgnoreCase("calzone")) {
            this.margarita = new MargaritaPizza();
            this.priceofMargaritaPizza = margarita.getBacon() * baconIngrPrc + margarita.getPepper() * pepperIngrPrc + margarita.getGarlic() * garlicIngrPrc
                    + margarita.getTomatoPaste() * tomatopasteIngrPrc;
            priceofPizza = priceofMargaritaPizza * qnt + 1.5;
        } else {
            this.margarita = new MargaritaPizza();
            this.priceofMargaritaPizza = margarita.getBacon() * baconIngrPrc + margarita.getPepper() * pepperIngrPrc + margarita.getGarlic() * garlicIngrPrc
                    + margarita.getTomatoPaste() * tomatopasteIngrPrc;
            priceofPizza = priceofMargaritaPizza * qnt + 1;
        }
        if (name.equalsIgnoreCase("pepperoni") && type.equalsIgnoreCase("calzone")) {
            this.pepperoni = new PepperoniPizza();
            this.priceofPepperoniPizza = pepperoni.getPepperoni() * pepperoniIngrPrc + pepperoni.getPepper() * pepperIngrPrc
                    + pepperoni.getGarlic() * garlicIngrPrc + pepperoni.getBacon() * baconIngrPrc + pepperoni.getTomatoPaste() * tomatopasteIngrPrc;
            priceofPizza = priceofPepperoniPizza * qnt + 1.5;
        } else {
            this.pepperoni = new PepperoniPizza();
            this.priceofPepperoniPizza = pepperoni.getPepperoni() * pepperoniIngrPrc + pepperoni.getPepper() * pepperIngrPrc
                    + pepperoni.getGarlic() * garlicIngrPrc + pepperoni.getBacon() * baconIngrPrc + pepperoni.getTomatoPaste() * tomatopasteIngrPrc;
            priceofPizza = priceofDiabloPizza * qnt + 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getPepperIngrPrc() {
        return pepperIngrPrc;
    }

    public double getTomatopasteIngrPrc() {
        return tomatopasteIngrPrc;
    }

    public double getCheeseIngrPrc() {
        return cheeseIngrPrc;
    }

    public double getSalamiIngrPrc() {
        return salamiIngrPrc;
    }

    public double getBaconIngrPrc() {
        return baconIngrPrc;
    }

    public double getGarlicIngrPrc() {
        return garlicIngrPrc;
    }

    public double getCornIngrPrc() {
        return cornIngrPrc;
    }

    public double getPepperoniIngrPrc() {
        return pepperoniIngrPrc;
    }

    public double getOlivesIngrPrc() {
        return olivesIngrPrc;
    }

    void getIngredients(String nameofPizza) {
        if (nameofPizza.equalsIgnoreCase("diable")) {
            System.out.println(diablo.getBacon());
            System.out.println(diablo.getCheese());
            System.out.println(diablo.getOlives());
            System.out.println(diablo.getTomatoPaste());
        }
        if (nameofPizza.equalsIgnoreCase("margarita")) {
            System.out.println("Bacon" + " " + margarita.getBacon() * baconIngrPrc + " $");
            System.out.println("Garlic" + " " + margarita.getGarlic() * garlicIngrPrc + " $");
            System.out.println("Pepper" + " " + margarita.getPepper() * pepperIngrPrc + " $" );
            System.out.println("Tomato Paste" + " " + margarita.getTomatoPaste() * tomatopasteIngrPrc + " $");
        }
    }

    public double getPriceofDiabloPizza() {
        return priceofDiabloPizza;
    }

    public void setPriceofDiabloPizza(double priceofDiabloPizza) {
        this.priceofDiabloPizza = priceofDiabloPizza;
    }

    public double getPriceofMargaritaPizza() {
        return priceofMargaritaPizza;
    }

    public void setPriceofMargaritaPizza(double priceofMargaritaPizza) {
        this.priceofMargaritaPizza = priceofMargaritaPizza;
    }

    public double getPriceofPepperoniPizza() {
        return priceofPepperoniPizza;
    }

    public void setPriceofPepperoniPizza(double priceofPepperoniPizza) {
        this.priceofPepperoniPizza = priceofPepperoniPizza;
    }
}
