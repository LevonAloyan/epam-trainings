package com.epam.javatrainings.io.customerUtil;

/**
 * Created by Hayk on 02.10.2021.
 */
public class FileSortinTest {
    public static void main(String[] args) {
        CustomerUtil.writeToFile("newFile.csv",CustomerUtil.readFromFile("existingFile.csv"));
    }
}
