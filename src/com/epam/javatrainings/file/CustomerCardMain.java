package com.epam.javatrainings.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CustomerCardMain {
    public static void main(String[] args) {
        CustomerCardMain customerCardMain = new CustomerCardMain();
        File file = new File("archiveend.txt");
        CustomerCard customerCard = new CustomerCard("Aram", "010202020", 36, "ADC36");
        customerCardMain.write(customerCard, file);
        customerCardMain.read(file);
        System.out.println(customerCard.getCardNumber());
        System.out.println(customerCard.toString());
    }

    public CustomerCard read(File file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            CustomerCard customerCard = (CustomerCard) objectInputStream.readObject();
            String encoder = String.valueOf(Base64.getDecoder().decode(customerCard.getCardNumber()));
            customerCard.setCardNumber(encoder);
            return customerCard;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(CustomerCard customerCard, File file) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            String str = Base64.getEncoder().encodeToString(customerCard.getCardNumber().getBytes(StandardCharsets.UTF_8));
            customerCard.setCardNumber(str);
            outputStream.writeObject(customerCard);
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
