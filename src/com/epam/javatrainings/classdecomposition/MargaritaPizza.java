package epam.javatrainings.classdecomposition;

public class MargaritaPizza extends Pizza {

//    Margarita pizza with the following ingredients: tomato paste, pepper, garlic, and bacon.
    private int tomatoPaste;
    private int garlic;
    private int bacon;
    private int pepper;

    final int TOMATO_PASTE_QNT = 3;
    final int GARLIC_QNT = 5;
    final int BACON_QNT = 4;
    final int PEPPER_QNT = 5;

    MargaritaPizza() {
        this.tomatoPaste = 1;
        this.garlic = 1;
        this.bacon = 2;
        this.pepper = 1;
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
    }

    public void setTomatoPaste(int tomatoPaste) {
        this.tomatoPaste = tomatoPaste;
    }

    public void setGarlic(int garlic) {
        this.garlic = garlic;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public void setPepper(int pepper) {
        this.pepper = pepper;
    }

    public int getTomatoPaste() {
        return tomatoPaste;
    }

    public int getGarlic() {
        return garlic;
    }

    public int getBacon() {
        return bacon;
    }

    public int getPepper() {
        return pepper;
    }
}
