package com.epam.javatrainings.io_stream.task_1.copyData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ViaBuffer {

    public void copyDataViaBuffer(String html, URL http) {
        InputStream inputStream;
        OutputStream outputStream;

        int length = 8192;

        try {
            inputStream = http.openStream();
            outputStream = new FileOutputStream(html);

            byte[] buffer = new byte[length];
            int readNum;

            while ((readNum = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readNum);
            }

            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
