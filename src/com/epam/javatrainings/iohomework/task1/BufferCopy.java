package com.epam.javatrainings.iohomework.task1;

import java.io.*;
import java.net.URL;

public class BufferCopy {

    public static void main(String[] args) {

        InputStream in = null;
        FileOutputStream out = null;
        try {
            URL url = new URL("http://example.com");
            in = url.openStream();
            out = new FileOutputStream("example_2.html");

            int len = in.available();
            byte[] buffer = new byte[8000];
            while (len > 0) {

                if (len < buffer.length) {buffer = new byte[len];}

                int bufferLen = buffer.length;
                for (int i = 0; i < bufferLen; i++) {buffer[i] = (byte) in.read();}

                len = len - buffer.length;
                out.write(buffer);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
