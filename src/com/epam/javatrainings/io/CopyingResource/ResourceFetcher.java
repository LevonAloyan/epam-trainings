package com.epam.javatrainings.io.CopyingResource;

import java.net.MalformedURLException;
import java.net.URL;

public class ResourceFetcher {

    private URL url;
    private String urlName;

    public ResourceFetcher(String url) {
        this.urlName = url.substring(0, url.lastIndexOf("."));
        try {
            this.url = new URL("https://" + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }
}
