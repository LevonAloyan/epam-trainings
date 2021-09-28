package com.epam.javatrainings.iohomework1;

import java.io.*;
import java.net.URI;

public class Task1 {
    public static void main(String[] args) {
        URI u = URI.create("https://www.google.com/");
        copyingByte_By_Byte(u);
        copyingViaBuffer(u);
    }
    public static void copyingByte_By_Byte(URI u){
        InputStream is=null;
        FileOutputStream fos=null;
        try {
            is = u.toURL().openStream();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        try {
            fos = new FileOutputStream( "C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework1\\copy1.html ");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        try {
            int i=0;
            do{
                System.out.println(i);
                i=is.read();
                fos.write(i);
            } while (i != -1);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        try {
            fos.close();
            is.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public static void copyingViaBuffer(URI u){
        System.out.println(("2 have started"));
        try (BufferedInputStream bis = new BufferedInputStream(u.toURL().openStream());
             FileOutputStream fos = new FileOutputStream("C:\\Users\\Vache Khachatryan\\Homework1\\src\\com\\epam\\javatrainings\\iohomework1\\copy2.html")) {
            byte[] data = new byte[8192];
            int i;
            while ((i = bis.read(data, 0, 1024)) != -1) {
                System.out.println(i);
                fos.write(data, 0, i);
            }
        } catch (IOException e) {
            // handles IO exceptions
        }
        System.out.println(("2 have ended"));

    }
}
