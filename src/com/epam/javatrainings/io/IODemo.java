package com.epam.javatrainings.io;

import java.io.*;

public class IODemo {

    public void read()  {
        Reader reader = null;
        Writer writer = null;
        try {
            int ch;
            reader = new FileReader("example.txt");
            writer = new FileWriter("example_copy.txt");
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        }catch (IOException e){
            System.out.println("something wrong");
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null){
                    writer.close();
                }
            }catch (IOException e){
                System.out.println("Can not close streams");
            }
        }

    }

    public void bufferedRead(){
        Reader reader = null;
        Writer writer = null;
        try {
           reader = new BufferedReader(
                    new FileReader(
                            "example.txt"),16000);

           writer = new BufferedWriter(
                   new FileWriter(
                           "example_copy_1.txt"
                   ),16000);
            int ch;

            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        try {
            if (reader != null) {
                reader.close();
            }
            if (writer != null){
                writer.close();
            }
        }catch (IOException e){
            System.out.println("Can not close streams");
        }
    }
    }

    private void write() throws IOException {
        Writer writer = new FileWriter("example.txt");
        writer.write("Hello");
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        IODemo ioDemo = new IODemo();

        long startBufferedRead = System.currentTimeMillis();
        ioDemo.bufferedRead();
        long endBufferedRead = System.currentTimeMillis();
        System.out.println(endBufferedRead-startBufferedRead);

        long start = System.currentTimeMillis();
        ioDemo.read();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
