package com.epam.javatrainings.TasksIO.task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1 task1 = new Task1();
        task1.downloadUrlFileAndCopyingByteByByte("https://www.facebook.com/margaryan.er/", "myFacebook.html");
        task1.downloadUrlFileAndCopyingViaBuffer("https://github.com/ErikMargaryan", "myGithub.html");
    }
}
