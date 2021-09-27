package com.epam.javatrainings.webpage;

import java.io.*;
import java.net.URL;

public class WebPageDownloader {

    private WebPageDownloader() {

    }

    public static void downloadPageBy8kbBuffer(String url) {

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new URL(url).openStream();
            os = new FileOutputStream("web_page.html");

            byte[] buffer = new byte[8000];
            while(is.read(buffer, 0, 8000)!=-1) {
                os.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null) {
                    is.close();
                }
                if(os!=null) {
                    os.close();
                }

            } catch (IOException e){
                System.out.println("Can not close streams");
            }
        }
    }

    public static void downloadPageByteByByte(String url) {

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new URL(url).openStream();
            os = new FileOutputStream("web_page.html");

            int bt;
            while((bt =is.read())!=-1) {
                os.write(bt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null) {
                    is.close();
                }
                if(os!=null) {
                    os.close();
                }

            } catch (IOException e){
                System.out.println("Can't close streams");
            }
        }
    }
}
