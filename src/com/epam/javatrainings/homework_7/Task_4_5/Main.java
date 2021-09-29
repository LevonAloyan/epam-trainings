package com.epam.javatrainings.homework_7.Task_4_5;

public class Main {
    public static void main(String [] args){
        Customer customer = new Customer("Davit","+374044404044","445555555454545588",100);
        Serializer.Serialize(customer);
        Customer deserializedCustomer = DeSerializer.deSerialize();
        System.out.println("Name:  " + deserializedCustomer.getName());
        System.out.println("PhoneNumber:  " + deserializedCustomer.getPhoneNumber());
        System.out.println("CardNumber:  " + deserializedCustomer.getCardNumber());
        System.out.println("Score:  " + deserializedCustomer.getScore());
    }
}