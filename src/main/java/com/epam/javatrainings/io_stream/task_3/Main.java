package com.epam.javatrainings.io_stream.task_3;

import com.epam.javatrainings.io_stream.task_3.deleteFile.DeleteFile;

public class Main {
    public static final String PATH = "task_3_temp";

    public static void main(String[] args) {

        DeleteFile d = new DeleteFile();
        d.deleteFile(PATH);
    }
}
