package com.epam.javatrainings.threads.sizecounter;

public final class PrintingThread extends Thread {
    private final FolderSizeCounter counter;

    public PrintingThread(FolderSizeCounter counter) {
        this.counter = counter;
    }

    private void printCurrentState() {
        System.out.printf("%,d bytes, %,d files, %,d folders%n", counter.getFolderSize(), counter.getFilesCount(), counter.getFoldersCount());
    }

    @Override
    public void run() {
        Thread counterThread = new Thread(counter);
        counterThread.start();

        while (counterThread.isAlive()) {
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
