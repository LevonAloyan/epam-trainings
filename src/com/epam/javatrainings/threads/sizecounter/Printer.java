package com.epam.javatrainings.threads.sizecounter;

public final class Printer implements Runnable {
    private final Thread thread;
    private final FolderSizeCounter counter;

    public Printer(FolderSizeCounter counter) {
        this.counter = counter;
        thread = new Thread(this);
    }

    public void printMetrics() {
        thread.start();
    }

    private void printCurrentState() {
        System.out.printf("%,d bytes, %,d files, %,d folders%n", counter.getFolderSize(), counter.getFilesCount(), counter.getFoldersCount());
    }

    @Override
    public void run() {
        counter.getThread().start();

        while (counter.getThread().isAlive()) {
            printCurrentState();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Prints the final state of all metrics generated after completing calculations execution flow
        printCurrentState();
    }
}
