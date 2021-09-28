package com.epam.javatrainings.io.getresource;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class ResourceFetcher {
    protected static final String DOWNLOAD_PATH = "resources/fetched/";

    protected String url;
    protected String outputFileName;
    protected URL urlObject;

    public ResourceFetcher(String url) {
        this(url, System.currentTimeMillis() + ".html");
    }

    public ResourceFetcher(String url, String outputFileName) {
        this.url = url;
        this.outputFileName = outputFileName;

        try {
            urlObject = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    abstract public void fetch();
}
