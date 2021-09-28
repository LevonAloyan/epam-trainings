package com.epam.javatrainings.iohomework2;

import javax.sql.XAConnection;

public class Customer implements Comparable<Customer>{

    private String name;
    private String phoneNumber;
    private int score;

    public Customer(StringBuffer data){
        name= data.substring(0, data.indexOf(","));
        data.delete(0, data.indexOf("+"));
        phoneNumber=data.substring(0,14);
        data.delete(0, 16);
        String scoreString=data.toString();
        try {
            score = Integer.parseInt(scoreString);
        }catch(Exception exc){
            System.out.println(("Number format is false!"));
        }
        System.out.println(name);
        System.out.println(phoneNumber);
        System.out.println(score);

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
}
