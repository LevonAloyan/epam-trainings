package com.epam.javatrainings.filehandling.csv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Stream;

public class CsvIntoCustomerReader {
  private static final String SPLIT_BY = ",";
  private final File csv;
  private final Set<Customer> customerSet =
      new TreeSet<>(Comparator.comparingInt(Customer::getScore));

  public CsvIntoCustomerReader(File csv) {
    this.csv = csv;
  }

  public Set<Customer> read() {
    try (Stream<String> stream = Files.lines(csv.toPath())) {
      stream.forEach(
          csvLine -> {
            String[] customer = csvLine.split(SPLIT_BY);
            try {
              customerSet.add(
                  new Customer(customer[0], customer[1], Integer.parseInt(customer[2]), "cardNum"));
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
              throw new CsvManipulationException("Failed to create Customer ", e.getCause());
            }
          });
    } catch (IOException e) {
      throw new CsvManipulationException("Failed while reading scv ", e.getCause());
    }
    return customerSet;
  }
}
