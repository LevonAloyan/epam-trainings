package com.epam.javatrainings.iohomework.task4;

import java.io.*;

public class CustomerIO {


    public void write(Customer customer, File file) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(customer);
        }

    }

    public Customer read(File file) throws IOException,ClassNotFoundException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Customer customer = (Customer) in.readObject();
            return customer;
        }

    }
}
