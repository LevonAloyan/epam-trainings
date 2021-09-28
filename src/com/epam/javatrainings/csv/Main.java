package com.epam.javatrainings.csv;

import com.epam.javatrainings.csv.util.CsvWriter;

public class Main {

    public static void main(String[] args) {

        //pass IO csv file paths in command line
//        String csvReadPath = args[0];
//        String scvWritePath  =  args[1];

        String csvReadPath = "C:\\GEV\\Java Projects\\epam-trainings\\src\\resources\\customers.csv";
        String scvWritePath = "C:\\GEV\\Java Projects\\epam-trainings\\src\\resources\\sorted_customers.csv";

        CsvWriter.writeSortedCustomersToNewCsv(csvReadPath, scvWritePath);
    }
}
