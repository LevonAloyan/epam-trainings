package com.epam.javatrainings.filehandling.downloadhtml;

import java.net.URL;

public class Main {

  public static void main(String[] args) {
    URL url = new ResourceLocator().createUrl();

    WebPageDownloader downloader = new WebPageDownloader(url);
    HTMLWriter writer = new HTMLWriter(url);

    byte[] dataDownloadedBytePerByte = downloader.download();
    writer.writeHtml(dataDownloadedBytePerByte);

    url = new ResourceLocator("/principles").createUrl();
    downloader = new WebPageDownloader(url);
    writer = new HTMLWriter(".htm", url);

    byte[] dataDownloadedByChunks = downloader.download(8);
    writer.writeHtml(dataDownloadedByChunks);
  }
}
