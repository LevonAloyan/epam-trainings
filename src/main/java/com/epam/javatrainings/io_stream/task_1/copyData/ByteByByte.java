package com.epam.javatrainings.io_stream.task_1.copyData;

import java.io.*;
import java.net.URL;

public class ByteByByte {

    public void copyDataByteByByte(String html, URL http) {

        InputStream inputStream;
        OutputStream outputStream;
        try {
            inputStream = http.openStream();
            outputStream = new FileOutputStream(html);

            byte[] bytes = inputStream.readAllBytes();

            outputStream.write(bytes);

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
