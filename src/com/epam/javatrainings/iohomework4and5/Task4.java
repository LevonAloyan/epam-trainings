package com.epam.javatrainings.iohomework4and5;


import java.io.*;
import java.util.TreeSet;

public class Task4 {
    public  static  void  main(String[] args) throws  FileNotFoundException{
        TreeSet<Customer> customerList=new TreeSet<Customer>();
        TreeSet<StringBuffer> objectDataList=new TreeSet<>();
        String filePath= "C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework4and5\\CustomerData.txt";
        String serializedFilePath ="C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework4and5\\serialized.txt";
        BufferedReader fl= new BufferedReader(new FileReader(String.valueOf(filePath)));
        String line = null;
        try {
            while((line=fl.readLine()) != null){
               StringBuffer sb=new StringBuffer(line);
               objectDataList.add(sb);
            }
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }finally {
            try{
                fl.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        serialize(objectDataList,customerList,serializedFilePath);
        deserialize(serializedFilePath);
    }
    public static Customer createCustomer(StringBuffer data){
        long forCardNumber=1;
        String name= data.substring(0, data.indexOf(","));
        data.delete(0, data.indexOf("+"));
        String phoneNumber=data.substring(0,14);
        data.delete(0, 16);
        String scoreString=data.toString();
        int score=0;
        try {
            score = Integer.parseInt(scoreString);
        }catch(Exception exc){
            System.out.println(("Number format is false!"));
        }

        Customer customer=new Customer(name, phoneNumber, score, Integer.toString(1));
        return customer;
    }
    public static void serialize(TreeSet<StringBuffer> objectDataList,TreeSet<Customer> customerList,String path){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            for (var obj : objectDataList) {
                    Customer customer = createCustomer(obj);
                    customer.encryptCardNumber();
                    oos.writeObject(customer);
                    customerList.add(customer);
                }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void deserialize(String path){
        try ( ObjectInputStream ois =
                      new ObjectInputStream(new FileInputStream(path)) )
        {
                Customer customer1 = (Customer) ois.readObject();
                customer1.decryptCardNumber();
                System.out.println("Deserialized object: " + customer1);
                Customer customer2 = (Customer)ois.readObject();
                customer2.decryptCardNumber();
                System.out.println("Deserialized object: " + customer2);
                Customer customer3 = (Customer)ois.readObject();
                customer3.decryptCardNumber();
                System.out.println("Deserialized object: " + customer3);
        }
        catch(Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }
}
