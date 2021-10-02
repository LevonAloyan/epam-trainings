package com.epam.javatrainings.IO.task_1;

public class Main {
    public static void main(String[] args){
        PageScraper pageScraper = new PageScraper();
        pageScraper.copyFileViaBuffer("http://example.com", "copy_via_buffer.html");
        pageScraper.copyFileByteByByte("http://example.com", "copy_byte_by_byte.html");
    }
}
