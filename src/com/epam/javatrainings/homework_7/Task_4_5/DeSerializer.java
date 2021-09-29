package com.epam.javatrainings.homework_7.Task_4_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class DeSerializer {
    public static Customer deSerialize(){
        Customer deserializedCustomer = null;

        try
        {
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            deserializedCustomer = (Customer) in.readObject();
        } catch(IOException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        assert deserializedCustomer != null;
        String cardNumber = new String(Base64.getDecoder().decode(deserializedCustomer.getCardNumber()));
        deserializedCustomer.setCardNumber(cardNumber);

        return deserializedCustomer;
    }
}
