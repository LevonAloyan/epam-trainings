package io;

import java.io.*;

public class SerializeObject {
    public static void main(String[] args) {
        Customer customer = new Customer("asd", "123456", 77);
        try {
        FileOutputStream fout = new FileOutputStream("customer.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(customer);
        FileInputStream fis = new FileInputStream("customer.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject().toString());

        } catch (IOException | ClassNotFoundException e ) {
            System.out.println("IO Exception " + e);
        }
    }

}
