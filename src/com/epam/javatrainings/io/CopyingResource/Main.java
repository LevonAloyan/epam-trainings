package com.epam.javatrainings.io.CopyingResource;

public class Main {

    public static void main(String[] args) {
        String url = "example.com";
        CopyByteByByte BbyB = new CopyByteByByte(url);
        CopyByBuffer byBuffer = new CopyByBuffer(url);

        BbyB.copyResource();

       // byBuffer.copyResource();
    }
}
