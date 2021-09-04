package com.epam.javatrainings.classdecomposition;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private static String path = "customers.txt";

    private DataStore(){}

    public static void write(Map<Long, Customer> customers){

        File file = new File(path);

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos) ) {

            oos.writeObject(customers);

        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Long,Customer> read(){

        File file = new File(path);
        Map<Long,Customer> customers = null;

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            customers = (Map<Long, Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("incompatible type");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return customers;
    }
}
