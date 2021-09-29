package com.epam.javatrainings.iohomework.task1;

import java.io.*;
import java.net.URL;

public class SimpleCopy {

    public static void main(String[] args){

        InputStream in = null;
        FileOutputStream out = null;
        try {
            URL url = new URL("http://example.com");
            in = url.openStream();
            out = new FileOutputStream("example_1.html");
            int c;
            while ((c = in.read()) != -1){
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
