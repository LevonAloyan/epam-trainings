package com.epam.javatrainings.io.getresource;

public class Main {
    public static void main(String[] args) {
        String resourceURL = "http://example.com";

        ResourceFetcher resourceFetcher = new ByteByByteResourceFetcher(resourceURL);
        System.out.printf("Fetching url %s and writing the output in the file %s%n",
                resourceFetcher.getUrl(), resourceFetcher.getOutputFileName());
        resourceFetcher.fetch();

        resourceFetcher = new BufferedResourceFetcher(resourceURL, "buffered.html");
        System.out.printf("Buffered fetching url %s and writing the output in the file %s%n",
                resourceFetcher.getUrl(), resourceFetcher.getOutputFileName());
        resourceFetcher.fetch();

        BufferedResourceFetcher bufferedResourceFetcher = new BufferedResourceFetcher("https://www.elastic.co/", "elastic.html");
        bufferedResourceFetcher.setBufferSize(1024 * 1024);
        System.out.printf("%s Buffered fetching url %s and writing the output in the file %s%n",
                bufferedResourceFetcher.getBufferSize(), bufferedResourceFetcher.getUrl(), bufferedResourceFetcher.getOutputFileName());
        bufferedResourceFetcher.fetch();


    }
}
