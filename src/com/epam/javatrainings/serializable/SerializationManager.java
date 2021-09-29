package com.epam.javatrainings.serializable;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class SerializationManager<T> {

    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectInputStream ois;
    private static ObjectOutputStream ous;

    private SerializationManager() {

    }


    public static <T> void write(T t, String fileName, String fieldNameToEncode) {
        //encode required field value and set new encoded value to that field
        try{
            Field field = t.getClass().getDeclaredField(fieldNameToEncode);
            field.setAccessible(true);
            String cardNumber = (String) field.get(t);
            String encodedCardNumber = Base64.getEncoder().encodeToString(cardNumber.getBytes(StandardCharsets.UTF_8));
            field.set(t, encodedCardNumber);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("there is no field named cardNumber or can't access it");
        }

        try {
            fos = new FileOutputStream(fileName);
            ous = new ObjectOutputStream(fos);
            ous.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> T read(String fileName, String fieldNameToDecode) {
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            T object = (T) ois.readObject();

            Field field = object.getClass().getDeclaredField(fieldNameToDecode);
            field.setAccessible(true);
            String cardNumber = (String) field.get(object);
            byte[] decodedArray = Base64.getDecoder().decode(cardNumber);
            String decodedCardNumber = new String(decodedArray, StandardCharsets.UTF_8);
            field.set(object, decodedCardNumber);

            return object;
        } catch (IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
