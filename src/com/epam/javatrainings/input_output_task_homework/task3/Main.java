package com.epam.javatrainings.input_output_task_homework.task3;

import com.epam.javatrainings.input_output_task_homework.task3.processor.ExtensionFilesEraser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input path");
        String path = scanner.nextLine();
        System.out.println("Please input file type");
        String fileType = scanner.nextLine();
        ExtensionFilesEraser.eraseExtensionFiles(path, fileType);
    }
}
