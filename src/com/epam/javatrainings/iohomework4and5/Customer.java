package com.epam.javatrainings.iohomework4and5;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Customer implements Serializable,Comparable<Customer>{
    private static long forCardNumber=0;
    private String name;
    private transient String phoneNumber;
    private int score;
    private String cardNumber;

    public Customer(String name, String phoneNumber, int score,String cardNumber){
       this.name=name;
       this.phoneNumber=phoneNumber;
       this.score=score;
       this.cardNumber=String.format("%08d",++forCardNumber);
    }

    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Customer o) {
        if(score>o.score){
            return 1;
        }else if(score<o.score){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", score=" + score +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public void encryptCardNumber(){
        cardNumber= Base64.getEncoder().encodeToString(cardNumber.getBytes());
    }
    public void decryptCardNumber(){
        cardNumber= new String(Base64.getDecoder().decode(cardNumber));
    }
}
