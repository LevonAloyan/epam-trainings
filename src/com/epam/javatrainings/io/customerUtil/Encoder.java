package com.epam.javatrainings.io.customerUtil;

import java.util.Base64;

/**
 * Created by Hayk on 04.10.2021.
 */
public class Encoder {
    public static String encodeToString(int num){
        String str=""+num;
        return new String(Base64.getEncoder().encodeToString(str.getBytes()));
    }

    public static int decodeToInt(String str){
        return Integer.parseInt(new String(Base64.getDecoder().decode(str.getBytes())));
    }
}
