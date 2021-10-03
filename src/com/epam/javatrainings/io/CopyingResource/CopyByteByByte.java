package com.epam.javatrainings.io.CopyingResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyByteByByte extends ResourceFetcher {

    private InputStream inputStream;
    private OutputStream outputStream;

    public CopyByteByByte(String url) {
        super(url);
    }

    public void copyResource() {
        try {
            this.inputStream = this.getUrl().openStream();
            this.outputStream = new FileOutputStream(this.getUrlName() + ".html");
            int str = 0;
            do {
                str = inputStream.read();
                if(str != -1) {
                    outputStream.write((char) str);
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
