package io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class WebPageContent {

    public static void getWebPageContent(String webPageUrl) {
        try {
            var url = new URL(webPageUrl);
            byte[] buffer = new byte[8 * 1024];
            var openStream = url.openStream();
            int bytesRead = 0;
            var writer = new FileOutputStream("example.html");
            while ((bytesRead = openStream.read(buffer)) != -1) {
                writer.write(buffer);
            }
            openStream.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        getWebPageContent("http://www.example.com");


    }
}