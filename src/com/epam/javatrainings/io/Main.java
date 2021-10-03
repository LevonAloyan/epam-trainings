package com.epam.javatrainings.io;

import com.epam.javatrainings.io.homework.UrlProgram;

import java.io.*;

public class Main {

    String page = UrlProgram.getPage("http://example.com");



    public static void main(String[] args) {
        Main main = new Main();
        Address address = new Address();
        address.setAddressLine("Address");
        address.setCountry("Armenia");
        address.setZipCode("3120");

        Student student = new Student("Levon", 1L, 27, "levon@epam.com");
        student.setAddress(address);
        main.writeObject(student, "archive.txt");
        Student student1 = main.readObject();
        System.out.println(student1);
//ASCII Table 7-bit Character Set
        for(int i=32;i<127;i++){
            System.out.write(i);
        }
        System.out.flush();

    }

    public Student readObject() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("archive.txt"))) {
            return (Student) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeObject(Student student, String filePath) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            outputStream.writeObject(student);
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

