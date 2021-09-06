package com.epam.javatrainings.classdecomposition.taskreader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TaskReader {

    private final Path path;

    public TaskReader(String filePath) {
        this.path = Paths.get(filePath);
    }

    public List<String> getTaskLines() {

        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            System.out.println("Failed to read the file");
        }

        return lines;
    }

}
