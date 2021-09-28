package com.epam.javatrainings.io.removetmp;

public class Main {
    public static void main(String[] args) {
        FileRemover.removeFiles("resources/temp/", "tmp");
    }
}
