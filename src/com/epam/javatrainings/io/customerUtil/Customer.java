package com.epam.javatrainings.io.customerUtil;

/**
 * Created by Hayk on 01.10.2021.
 */
public class Customer {
    private String name;
    private transient String phone;
    private int score;
    private String cardNumber;

    public Customer(String name, String phone, int score, int cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = Encoder.encodeToString(cardNumber);
    }

    public Customer(String name, String phone, int score){
        this.name = name;
        this.phone = phone;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCardNumber(int num){
        this.cardNumber=Encoder.encodeToString(num);
    }

    public int getCardNumber(){
        return Encoder.decodeToInt(this.cardNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (score != customer.score) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        return phone != null ? phone.equals(customer.phone) : customer.phone == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }

    @Override
    public String toString() {
        return  name + ", " + phone + ", " + score+"\n";
    }
}
