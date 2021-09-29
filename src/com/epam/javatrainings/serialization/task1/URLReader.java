package com.epam.javatrainings.serialization.task1;

import java.io.*;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws IOException {
        URLReader urlReader = new URLReader();
        long startBufferedRead = System.currentTimeMillis();
        //   urlReader.readWithBuffer("http://example.com", "example.html");
      urlReader.readByteByByte("example.html", "example2.html");
        long endBufferedRead = System.currentTimeMillis();
        System.out.println(endBufferedRead - startBufferedRead);

    }

    public void readWithBuffer(String readFrom, String writeInto) {
        Reader reader = null;
        Writer writer = null;

        try {

            URL exampleURL = new URL(readFrom);
            int ch;
            InputStream inputStream = exampleURL.openStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            writer = new FileWriter(writeInto);
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } catch (IOException e) {
            System.out.println("something wrong");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Can not close streams");
            }
        }
    }


    public void readByteByByte(String readFrom, String writeInto) {
        Reader reader = null;
        Writer writer = null;

        try {


            int ch;
            reader = new FileReader(readFrom);
            writer = new FileWriter(writeInto);
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } catch (IOException e) {
            System.out.println("something wrong");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Can not close streams");
            }
        }
    }


}
