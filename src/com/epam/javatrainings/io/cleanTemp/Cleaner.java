package com.epam.javatrainings.io.cleanTemp;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hayk on 03.10.2021.
 */
public class Cleaner {
    public static void clean(String dir,String extension){
        try {
            delete(new File(dir),extension);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void delete(File f,String extension) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles()) {
                delete(c, extension);
            }
        }else {
            String name=f.getName();
            String extension1=name.substring(name.lastIndexOf(".")+1);
            if (extension1.equals(extension)){
                f.delete();
            }
        }
    }
}
