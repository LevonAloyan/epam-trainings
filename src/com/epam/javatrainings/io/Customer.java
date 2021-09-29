package io;

import java.beans.Transient;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer implements Serializable{
    private String name;
    private transient String phoneNumber;
    private Integer score;
//    private Integer cardNumber;

    public int getScore() {
        return score;
    }

    Customer(String name, String phoneNumber, Integer score) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.score = score;
//        this.cardNumber = cardNumber;
    }

    static List<Customer> customerList = new ArrayList<>();

    public  void addToList(Customer customer) {
        customerList.add(customer);
    }

    public void showListOfCustomer() {
        System.out.println(customerList);
    }

    @Override
    public String toString() {
        return name + ", " + phoneNumber + ", " + score + "\n";
    }

    private int encrypt(int figure) {
        return figure << 2;
    }

    private int decrypt(int figure) {
        return figure >> 2;
    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        this.cardNumber = encrypt(cardNumber);
//        out.defaultWriteObject();
//    }

//    private void readObject (ObjectInputStream in)
//            throws IOException, ClassNotFoundException {
//
//        in.defaultReadObject();
//        this.cardNumber = decrypt(cardNumber);
//        in.registerValidation((ObjectInputValidation) new Customer(
//                name, phoneNumber, score, cardNumber), 0);
//    }


    public static void readCSVFileAndSortByScore(String filePath) {
        List<Customer> tmpCustomerList = new ArrayList<>();
        Comparator<Customer> customerScoreComparator = Comparator.comparing(Customer::getScore);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            int converFromStringToInt = 0;
            String reader = "";
            while ((reader = bufferedReader.readLine()) != null) {
                String[] tmpValue= reader.replaceAll("\\s","").split(",");
                converFromStringToInt = Integer.valueOf(tmpValue[2]);
                Customer customer = new Customer(tmpValue[0], tmpValue[1], converFromStringToInt);
                tmpCustomerList.add(customer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tmpCustomerList.sort(customerScoreComparator);
        try {
            Writer writer = new FileWriter("result_from_object_to_file.txt");
            for (Customer x: tmpCustomerList) {
                writer.write(x.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readCSVFileAndSortByScore(args[0]);
    }

}
