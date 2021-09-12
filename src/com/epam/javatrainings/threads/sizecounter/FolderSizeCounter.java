package com.epam.javatrainings.threads.sizecounter;

import java.io.File;

public class FolderSizeCounter implements Runnable {
    private Thread thread;
    private String folderPath;
    private long folderSize;
    private int filesCount;
    private int foldersCount;

    public FolderSizeCounter(String folderPath) {
        this.folderPath = folderPath;
        thread = new Thread(this);
    }

    public long getFolderSize() {
        return folderSize;
    }

    public Thread getThread() {
        return thread;
    }

    public int getFilesCount() {
        return filesCount;
    }

    public int getFoldersCount() {
        return foldersCount;
    }

    @Override
    public void run() {
        File folder = new File(folderPath);
        countMetricsForFolder(folder);
    }

    private void countMetricsForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            filesCount++;
            if (fileEntry.isDirectory()) {
                foldersCount++;
                countMetricsForFolder(fileEntry);
            } else {
                folderSize += fileEntry.length();
            }
        }
    }
}
