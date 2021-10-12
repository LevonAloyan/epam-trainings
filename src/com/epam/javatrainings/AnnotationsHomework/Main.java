package com.epam.javatrainings.AnnotationsHomework;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        String name;
        String email;
        LocalDate birthday;
        int discountRate;
        do {
            name = getName();
            email = getEmail();
            birthday = getBirthday();
            discountRate = getDiscountRate();
        }while(Validation.validateAll(name,email,birthday,discountRate));
    }
    public static String getName(){
        boolean isRight=false;
        String name="";
        while(!isRight) {
            try {
                System.out.print("Write name: ");
                Scanner settingName = new Scanner(System.in);
                name = settingName.next();
                isRight=true;
            }catch(Exception exc){
                System.out.print("Wrong format! Try again!");
            }
        }
        return  name;
    }
    public static String getEmail(){
        boolean isRight=false;
        String email="";
        while(!isRight) {
            try {
                System.out.print("Write Email: ");
                Scanner settingName = new Scanner(System.in);
                email = settingName.next();
                isRight=true;
            }catch(Exception exc){
                System.out.print("Wrong format! Try again!");
            }
        }
        return  email;
    }
    public static LocalDate getBirthday(){
        boolean isRight=false;
        LocalDate birthday=LocalDate.EPOCH;
        while(!isRight){
            try{
                System.out.print("Write your birthday(Format: year-month-day): ");
                Scanner settingBirthday = new Scanner(System.in);
                String birth=settingBirthday.next();
                birthday=LocalDate.parse(birth);
                isRight=true;
            }catch (Exception exc){
                System.out.println("Wrong format! Try again!");
            }
        }
        return  birthday;
    }
    public static int getDiscountRate(){
        boolean isRight=false;
        int discountRate=0;
        while(!isRight){
            try{
                System.out.print("Write discount rate: ");
                Scanner settingDiscount = new Scanner(System.in);
                discountRate=settingDiscount.nextInt();
                isRight=true;
            }catch (Exception exc){
                System.out.println("Wrong format! Try again!");
            }
        }
        return  discountRate;
    }
}
