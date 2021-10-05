package com.epam.javatrainings.file;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class OpenStream {
    public static void main(String[] args) {
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            URL url=new URL("http://example.com");
            inputStream=url.openStream();
            fileOutputStream=new FileOutputStream("examplebyte.html");
            int ch;
            while ((ch=inputStream.read())!=-1){
                fileOutputStream.write((char)ch);
                System.out.println(ch);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
