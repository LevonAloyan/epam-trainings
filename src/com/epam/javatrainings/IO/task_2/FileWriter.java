package com.epam.javatrainings.IO.task_2;

import java.io.PrintWriter;
import java.util.TreeSet;

public class FileWriter {

    public void writeInFile(String filepath, TreeSet<Customer> customerSet){
        try {
            PrintWriter writer = new PrintWriter(filepath);

            for (Customer c : customerSet){
                String line = c.toString();
                writer.println(line);
            }
            writer.flush();
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}
