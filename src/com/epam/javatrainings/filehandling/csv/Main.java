package com.epam.javatrainings.filehandling.csv;

import java.io.File;
import java.util.Set;
import java.io.IOException;

/**
 * Requirements
 * 1. Receives a file as a command line parameter.
 * 2. Reads all lines of a file into a Customer object
 * 3. Sorts by the score field
 * 4. The result of sorting is output to a new file.
 * -------------------------------------------------
 * In order to pass file as a command line parameter
 * click on the "Main" button in the top right corner of IDEA(between the green hummer and the green right arrow icon)
 * select "Edit Configurations..."
 * ALT+R hotkey will focus the input where we need to type file name: customerData.csv
 * then -> "Apply" -> "OK"
 */
public class Main {
  public static void main(String[] args) throws IOException {
    File csvFile = new ArgsProcessor(args).getFile();

    CsvIntoCustomerReader reader = new CsvIntoCustomerReader(csvFile);
    Set<Customer> customers = reader.read();

    CustomerToFileWriter writer = new CustomerToFileWriter(ArgsProcessor.BASE_PATH, "output", ".txt");
    writer.write(customers);
  }
}
