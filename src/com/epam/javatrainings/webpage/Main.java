package com.epam.javatrainings.webpage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {

        String url = "https://google.com";

        WebPageDownloader.downloadPageBy8kbBuffer(url);
        File file = new File("web_page.html");

        byte[] bytes;
        try {
            bytes = Files.readAllBytes(file.toPath());
            Files.write(file.toPath(), bytes);
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }


// Same thing with byte-by-byte buffer
//        WebPageDownloader.downloadPageByteByByte(url);

    }
}
