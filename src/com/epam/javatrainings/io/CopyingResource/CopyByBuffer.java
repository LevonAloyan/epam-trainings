package com.epam.javatrainings.io.CopyingResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyByBuffer extends ResourceFetcher {

    private static int DEFAULT_BUFFER_SIZE = 8192;

    private InputStream inputStream;
    private OutputStream outputStream;

    public CopyByBuffer(String url) {
        super(url);
    }

    public void copyResource() {
        try {
            this.inputStream = this.getUrl().openStream();
            this.outputStream = new FileOutputStream(this.getUrlName() + ".html");
            int str = 0;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            do {
                str = inputStream.read(buffer);
                if (str != -1) {
                    outputStream.write(buffer);
                }
            } while (str != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
