package com.epam.javatrainings.io_stream.task_1;

import com.epam.javatrainings.io_stream.task_1.copyData.ByteByByte;
import com.epam.javatrainings.io_stream.task_1.copyData.ViaBuffer;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        URL httpAddress = null;
        String htmlAddress = "task1/byteByByte.html";

        try {
            httpAddress = new URL("http://example.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assert httpAddress != null;

        ByteByByte task1 = new ByteByByte();
        task1.copyDataByteByByte(htmlAddress, httpAddress);

        ViaBuffer obj = new ViaBuffer();

        String htmlAddress2 = "task1/viaBuffer.html";
        obj.copyDataViaBuffer(htmlAddress2, httpAddress);
    }
}
