package com.epam.javatrainings.homework_7.Task_4_5;

import java.io.*;
import java.util.Base64;

public class Serializer {
    public static void Serialize(Customer customer){
        try
        {
            FileOutputStream file = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            String s = Base64.getEncoder().encodeToString(customer.getCardNumber().getBytes());
            customer.setCardNumber(s);
            out.writeObject(customer);
            out.close();
            file.close();
        }  catch(IOException ex)
        {
            ex.printStackTrace();
        }

    }
}
