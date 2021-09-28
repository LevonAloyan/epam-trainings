package com.epam.javatrainings.iohomework2;

import java.io.*;
import java.util.TreeSet;

public class Task2 {
    public  static  void  main(String[] args) throws  FileNotFoundException{
        TreeSet<Customer> customerList=new TreeSet<Customer>();
        TreeSet<StringBuffer> objectDataList=new TreeSet<>();
        String filePath= "C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework2\\CustomerData.txt";
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
        while(objectDataList.isEmpty()==false){
            Customer customer=new Customer(objectDataList.pollFirst());
            customerList.add(customer);
        }
        FileWriter newCustomerData=null;
        try{
            newCustomerData=new FileWriter("C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework2\\NewCustomerData.txt");
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for(var customer: customerList){
            try {
                newCustomerData.write(customer.getName() + ", " + customer.getPhoneNumber() + ", " + customer.getScore() + "\n");
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        try{
            newCustomerData.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
