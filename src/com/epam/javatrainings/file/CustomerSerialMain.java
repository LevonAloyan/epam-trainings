package com.epam.javatrainings.file;

import java.io.*;

public class CustomerSerialMain {
    public static void main(String[] args) {
        CustomerSerialMain customerSerialMain = new CustomerSerialMain();
        customerSerialMain.writeObject();
        Customer customer=customerSerialMain.readObject();
        System.out.println(customer.getScore());
        System.out.println(customer.getClass());
    }

    public Customer readObject() {
//        ObjectInputStream objectInputStream=null;
        try( ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("archived.txt"))) {
       return (Customer) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeObject() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("archived.txt"));
            Customer customer = new Customer("Shant", "+374101010", 10);
            outputStream.writeObject(customer);
            System.out.println(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
