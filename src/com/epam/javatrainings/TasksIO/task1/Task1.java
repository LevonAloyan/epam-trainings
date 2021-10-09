package com.epam.javatrainings.TasksIO.task1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task1 {

    public void downloadUrlFileAndCopyingByteByByte(String webpage, String myPath) throws IOException {
        ReadableByteChannel readableByteChannel = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(webpage);
            readableByteChannel = Channels.newChannel(url.openStream());
            fileOutputStream = new FileOutputStream(myPath);

            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (readableByteChannel != null) {
                readableByteChannel.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public void downloadUrlFileAndCopyingViaBuffer(String webpage, String myPath) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(webpage);
            bufferedInputStream = new BufferedInputStream(url.openStream());
            fileOutputStream = new FileOutputStream(myPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }        }

    }


}
