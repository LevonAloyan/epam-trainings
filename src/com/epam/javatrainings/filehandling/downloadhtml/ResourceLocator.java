package com.epam.javatrainings.filehandling.downloadhtml;

import java.net.URL;
import java.net.MalformedURLException;

public final class ResourceLocator {
  private static final String DEFAULT_PROTOCOL = "https";
  private static final String DEFAULT_HOST = "java-design-patterns.com";
  private static final int DEFAULT_PORT = 443;
  private static final String DEFAULT_FILE = "/patterns";


  private final String protocol;
  private final String host;
  private final int port;
  private final String file;

  public ResourceLocator(String protocol, String host, int port, String file) {
    this.protocol = protocol;
    this.host = host;
    this.port = port;
    this.file = file;
  }

  public ResourceLocator() {
    this(DEFAULT_PROTOCOL, DEFAULT_HOST, DEFAULT_PORT, DEFAULT_FILE);
  }

  public ResourceLocator(String file) {
    this(DEFAULT_PROTOCOL, DEFAULT_HOST, DEFAULT_PORT, file);
  }

  public URL createUrl() {
    URL url;
    try {
      url = new URL(protocol, host, port, file);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Failed to create URL object with given params");
    }
    return url;
  }
}
