package epam.javatrainings.classdecomposition;

public class DiabloPizza extends Pizza {
    private int tomatoPaste;
    private int cheese;
    private int bacon;
    private int olives;

    final int TOMATO_PASTE_QNT = 5;
    final int CHEESE_QNT = 5;
    final int BACON_QNT = 5;
    final int OLIVES_QNT = 5;

    DiabloPizza() {
        this.tomatoPaste = 1;
        this.cheese = 3;
        this.bacon = 2;
        this.olives = 3;
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
        if (name.equalsIgnoreCase("cheese")) {
            if (qnt < CHEESE_QNT) {
                setCheese(qnt);
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
        if (name.equalsIgnoreCase("olives")) {
            if (qnt < OLIVES_QNT) {
                setOlives(qnt);
            } else {
                System.out.println("Pizza is already Full, Sorry");
                return;
            }
        } else {
            System.out.println("Choice doesnt exists, sorry!");
        }
    }

    public void setTomatoPaste(int tomatoPaste) {
        this.tomatoPaste = tomatoPaste;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public void setOlives(int olives) {
        this.olives = olives;
    }

    public int getTomatoPaste() {
        return tomatoPaste;
    }

    public int getCheese() {
        return cheese;
    }

    public int getBacon() {
        return bacon;
    }

    public int getOlives() {
        return olives;
    }
}
