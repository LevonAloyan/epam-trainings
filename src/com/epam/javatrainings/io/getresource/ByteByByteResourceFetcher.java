package com.epam.javatrainings.io.getresource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteByByteResourceFetcher extends ResourceFetcher {
    public ByteByByteResourceFetcher(String url) {
        super(url);
    }

    public ByteByByteResourceFetcher(String url, String outputFileName) {
        super(url, outputFileName);
    }

    @Override
    public void fetch() {
        int nextByte;
        try (InputStream inputStream = urlObject.openStream();
             OutputStream outputStream = new FileOutputStream(DOWNLOAD_PATH + outputFileName)) {

            while ((nextByte = inputStream.read()) != -1) {
                outputStream.write(nextByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
