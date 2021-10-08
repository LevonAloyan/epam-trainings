package com.epam.javatrainings.io.downloadFile;

/**
 * Created by Hayk on 30.09.2021.
 */
public class IoTest {
    public static void main(String[] args) {
         FileDownload.bufferedDownload(4096,"http://example.com","C:\\Users\\Hayk\\Desktop\\example.html");
         FileDownload.bufferedDownload(4096,"http://example.com","C:\\Users\\Hayk\\IdeaProjects\\epam-trainings\\src\\com\\epam\\javatrainings\\io\\downloadFile\\example.html");
    }
}
