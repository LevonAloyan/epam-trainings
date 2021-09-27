package com.epam.javatrainings.io.taskone;

public class Test {

  private static final String URL_PAGE = "http://example.com";
  private static final String NAME_FILE = "test.html";
  private static final int GIVEN_BUFFER_SIZE = 8;

  public static void main(String[] args) {

    //  1. Implement copying byte-by-byte.
    IOUtil.copyPage(URL_PAGE, NAME_FILE);

    //  2. Implement copying via 8kb buffer.
    IOUtil.copyPage(URL_PAGE, NAME_FILE, GIVEN_BUFFER_SIZE);
  }
}
