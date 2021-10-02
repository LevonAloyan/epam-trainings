package com.epam.javatrainings.IO.task_1;

import java.io.*;
import java.net.URL;

public class PageScraper {
    public  void copyFileByteByByte(String pageURL,String filePath) {
        try{
            URL url = new URL(pageURL);
            InputStream inputStream = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            FileWriter mw = new FileWriter(filePath);
            while ((s = reader.readLine()) != null) {
                mw.write(s);
                System.out.println(s);
            }
            mw.close();
        } catch (Exception e){
            System.out.println("something wrong " + e.getMessage());
        }
    }

    public  void copyFileViaBuffer(String pageURL,String filePath){
        try{
        URL url = new URL(pageURL);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fos = new FileOutputStream(filePath);
            {
                byte[] data = new byte[8192];
                int i;
                while ((i = bis.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, i);
                }
            }}
        catch (IOException e) {
            System.out.println("something wrong " + e.getMessage());
        }

    }
}
