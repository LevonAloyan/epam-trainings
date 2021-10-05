package com.epam.javatrainings.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenStreamone {
    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("http://example.com");
            inputStream = url.openStream();
            fileOutputStream = new FileOutputStream("examplebyteeight.html");
            byte[] bytes = new byte[8000];
            int lengt = inputStream.available();
            System.out.println(lengt);
            while (lengt > 0) {
                if (lengt < bytes.length) {
                    bytes = new byte[lengt];
                }
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i]=(byte)inputStream.read();
                }
                lengt=lengt-bytes.length;
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
