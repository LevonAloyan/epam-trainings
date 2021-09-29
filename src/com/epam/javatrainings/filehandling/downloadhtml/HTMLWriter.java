package com.epam.javatrainings.filehandling.downloadhtml;

import java.net.URL;

public final class HTMLWriter extends FileWriter {
  private static final String DIR = "epam-trainings/src/com/epam/javatrainings/filehandling/downloadhtml/";
  private static final String FILE_NAME = "index";
  private static final String EXTENSION = ".html";
  private final String externalResourceBase;

  public HTMLWriter(String dir, String name, String extension, URL url) {
    super(dir, name, extension);
    this.externalResourceBase = url.getProtocol().concat("://").concat(url.getHost()).concat("/");
  }

  public HTMLWriter(URL url) {
    this(DIR, FILE_NAME, EXTENSION, url);
  }

  public HTMLWriter( String extension, URL url) {
    this(DIR, FILE_NAME, extension, url);
  }

  private byte[] replaceRelativeLinksToExternal(byte[] pageData) {
    return new String(pageData)
        .replaceAll("href=\"/", "href=\"" + externalResourceBase + "")
        .replaceAll("src=\"/(?!/)", "src=\"" + externalResourceBase + "")
        .getBytes();
  }

  public void writeHtml(byte[] data) {
    super.write(replaceRelativeLinksToExternal(data));
  }
}
