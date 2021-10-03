package com.epam.javatrainings.io.downloadFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Hayk on 30.09.2021.
 */
public class FileDownload {

    private FileDownload() {
    }

    public void downloadByByte(String urlAddress, String filePath) {
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {
            inputStream = new URL(urlAddress).openStream();
            outputStream = new FileOutputStream(filePath);
            int c;
            while ((c = inputStream.read()) > 0) {
                outputStream.write(c);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bufferedDownload(int size,String urlAddress, String filePath){
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {
            inputStream = new URL(urlAddress).openStream();
            outputStream = new FileOutputStream(filePath);
            byte[] bytes=new byte[size];
            while (inputStream.read(bytes)>0) {
                outputStream.write(bytes);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}