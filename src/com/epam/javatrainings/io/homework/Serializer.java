package com.epam.javatrainings.io.homework;

import java.io.*;
import java.util.Base64;

public class Serializer {
  public static void serialize(Customer customer, String path) {
    try (FileOutputStream fos = new FileOutputStream(new File(path))) {
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      customer.setCard(Base64.getEncoder().encodeToString(customer.getCard().getBytes()));
      oos.writeObject(customer);
      fos.close();
      oos.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
    public static void deSerialize(String path){
      Customer serialized = null;
      try (FileInputStream fis = new FileInputStream(new File(path))){
          ObjectInputStream objectInputStream = new ObjectInputStream(fis);
          serialized = (Customer) objectInputStream.readObject();
          serialized.setCard (String.valueOf (Base64.getDecoder().decode(serialized.getCard())));
          fis.close();
          objectInputStream.close();
      } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace ();
      }
    }
}
