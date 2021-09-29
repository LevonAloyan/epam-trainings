package com.epam.javatrainings.homework_7.Task1;
import java.net.URL;
import java.io.*;

public class DataFetcher {
    public static void Download(String urlString,String path) {
        File f = new File(path);
        try {
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }

            URL url = new URL(urlString);
            InputStream ins = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String str;
            FileWriter mw = new FileWriter(path);
            while ((str = reader.readLine()) != null) {
                mw.write(str);
                System.out.println(str);
            }
            mw.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}