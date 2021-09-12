package com.epam.javatrainings.threads.sizecounter;

public class SizeCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        FolderSizeCounter counter = new FolderSizeCounter("/Users/araGasparyan/ocr/labeling/pages");
        Printer printer = new Printer(counter);
        printer.printMetrics();
    }


}
