package com.epam.javatrainings.io.getresource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedResourceFetcher extends ResourceFetcher {
    private int bufferSize = 8192;

    public BufferedResourceFetcher(String url) {
        super(url);
    }

    public BufferedResourceFetcher(String url, String outputFileName) {
        super(url, outputFileName);
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public void fetch() {
        byte[] buffer = new byte[bufferSize];

        try (InputStream inputStream = urlObject.openStream();
             OutputStream outputStream = new FileOutputStream(DOWNLOAD_PATH + outputFileName)) {

            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
