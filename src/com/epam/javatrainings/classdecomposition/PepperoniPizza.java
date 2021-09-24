package epam.javatrainings.classdecomposition;

public class PepperoniPizza extends Pizza {
    private int tomatoPaste;
    private int garlic;
    private int bacon;
    private int pepper;
    private int pepperoni;

    final int TOMATO_PASTE_QNT = 2;
    final int GARLIC_QNT = 5;
    final int BACON_QNT = 6;
    final int PEPPER_QNT = 5;
    final int PEPPERONI_QNT = 5;

    PepperoniPizza() {
        this.tomatoPaste = 1;
        this.garlic = 2;
        this.bacon = 2;
        this.pepper = 2;
        this.pepperoni = 3;
    }

    @Override
    void addIngredients(String name, int qnt) {
        if (name.equalsIgnoreCase("tomatoPaste")) {
            if (qnt < TOMATO_PASTE_QNT) {
                setTomatoPaste(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        }
        if (name.equalsIgnoreCase("garlic")) {
            if (qnt < GARLIC_QNT) {
                setGarlic(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        }
        if (name.equalsIgnoreCase("bacon")) {
            if (qnt < BACON_QNT) {
                setBacon(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        }
        if (name.equalsIgnoreCase("pepper")) {
            if (qnt < PEPPER_QNT) {
                setPepper(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        } else {
            System.out.println("Choice doesnt exists, sorry!");
        }
        if (name.equalsIgnoreCase("pepperoni")) {
            if (qnt < PEPPERONI_QNT) {
                setPepper(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        } else {
            System.out.println("Choice doesnt exists, sorry!");
        }
    }

    public int getTomatoPaste() {
        return tomatoPaste;
    }

    public void setTomatoPaste(int tomatoPaste) {
        this.tomatoPaste = tomatoPaste;
    }

    public int getGarlic() {
        return garlic;
    }

    public void setGarlic(int garlic) {
        this.garlic = garlic;
    }

    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public int getPepper() {
        return pepper;
    }

    public void setPepper(int pepper) {
        this.pepper = pepper;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(int pepperoni) {
        this.pepperoni = pepperoni;
    }
}
