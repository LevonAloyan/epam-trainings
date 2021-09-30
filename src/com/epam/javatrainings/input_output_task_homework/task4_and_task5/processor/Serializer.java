package com.epam.javatrainings.input_output_task_homework.task4_and_task5.processor;

import com.epam.javatrainings.input_output_task_homework.task2.persistance.Customer;

import java.io.*;

public class Serializer {
    public static void serialize(Customer customer, String filePath){
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            customer.setCardNumber(Decoder.encryptingCardNumber(customer.getCardNumber()));
            objectOutputStream.writeObject(customer);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String deserialize(String filePath){
        Customer deserializeCustomer = null;
        try(FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializeCustomer = (Customer) objectInputStream.readObject();
            deserializeCustomer.setCardNumber(Decoder.decryptingCardNumber(deserializeCustomer.getCardNumber()));
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert deserializeCustomer != null;
        return deserializeCustomer.toString();
    }
}
