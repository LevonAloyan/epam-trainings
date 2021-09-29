package com.epam.javatrainings.filehandling.downloadhtml;

import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public final class WebPageDownloader {
  private static final int BYTES_IN_KILOBYTE = 1024;
  private final URL url;
  private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

  public WebPageDownloader(URL url) {
    this.url = url;
  }

  private byte[] downloadWebPage(byte[] bufferVolume) {
    try (InputStream is = url.openStream()) {
      int b;
      while ((b = is.read(bufferVolume)) > 0) {
        baos.write(bufferVolume, 0, b);
      }
    } catch (IOException e) {
      throw new FileManipulationException("Failed to download from the web.", e.getCause());
    }
    return baos.toByteArray();
  }

  public byte[] download() {
    return downloadWebPage(new byte[1]);
  }

  public byte[] download(int bufferSize) {
    if (bufferSize < 1) {
      throw new IllegalArgumentException("Please provide valid buffer size(in kB)");
    }
    return downloadWebPage(new byte[bufferSize * BYTES_IN_KILOBYTE]);
  }
}
