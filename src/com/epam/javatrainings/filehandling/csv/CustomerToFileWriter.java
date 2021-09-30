package com.epam.javatrainings.filehandling.csv;

import java.util.Set;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class CustomerToFileWriter {
  private final String filePath;

  public CustomerToFileWriter(String dir, String name, String extension) {
    this.filePath = dir.concat(name).concat(extension);
  }

  private byte[] getBytes(Set<Customer> customers) {
    return customers.stream()
        .map(
            c ->
                String.join(",", c.getName(), c.getPhoneNumber(), String.valueOf(c.getScore()))
                    .concat("\n"))
        .reduce("", String::concat)
        .getBytes();
  }

  public void write(Set<Customer> customers) {
    byte[] data = getBytes(customers);
    try (OutputStream outputStream = new FileOutputStream(filePath)) {
      outputStream.write(data);
    } catch (IOException e) {
      throw new CsvManipulationException("Failed to write to the file.", e.getCause());
    }
  }
}
