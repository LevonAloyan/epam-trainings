package com.epam.javatrainings.tmpremoval;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TempFilesCleaner {

    private TempFilesCleaner() {

    }

    public static void cleanTmpFiles(String uri) {
        try (Stream<Path> pathStream = Files.walk(Paths.get(uri), Integer.MAX_VALUE)) {
            pathStream
                    .map(Path::toFile)
                    .filter(file -> file.getName().endsWith(".tmp"))
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
