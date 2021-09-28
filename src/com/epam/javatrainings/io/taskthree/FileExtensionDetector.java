package com.epam.javatrainings.io.taskthree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileExtensionDetector {

  public static void removeFileByExtension(Path path, String fileExtension) throws IOException {

    try (Stream<Path> walk = Files.walk(path)) {

      walk.filter(Files::isRegularFile)
          .filter(p -> p.getFileName().toString().endsWith(fileExtension))
          .sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::delete);
    }
  }
}
