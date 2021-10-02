package com.epam.javatrainings.io.homework;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlProgram {
    public static String getPage(String address){
        StringBuilder builder = new StringBuilder();
        try {
            URI uri = new URI(address);
            URL url = uri.toURL();
            try (InputStream is = url.openStream ()) {

                byte[] bytes = new byte[8192];
                int c;
                while ((c = is.read (bytes, 0, 8192)) != -1) {
                    builder.append (new String (bytes, 0, c));
                }
            }
        } catch (URISyntaxException | IOException e) {
                e.printStackTrace ();
        }
        return builder.toString();
    }
}
