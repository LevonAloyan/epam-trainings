package com.epam.javatrainings.filehandling.downloadhtml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class FileWriter {
  private final String filePath;

  protected FileWriter(String dir, String name, String extension) {
    this.filePath = dir.concat(name).concat(extension);
  }

  protected void write(byte[] data) {
    try (OutputStream outputStream = new FileOutputStream(filePath)) {
      outputStream.write(data);
    } catch (IOException e) {
      throw new FileManipulationException("Failed to write to the file.", e.getCause());
    }
  }
}
