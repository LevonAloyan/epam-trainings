package com.epam.javatrainings.multithreading;

public class Test {

    public static void main(String[] args) {
//        BoundedBlockingBuffer<String> buffer = new BoundedBlockingBuffer<>();
//
//        for (int i = 0; i < 10; i++) {
//            int count = i;
//            new Thread(() -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                buffer.put("thread_" + count);
//            }).start();
//
//            new Thread(buffer::pick).start();
//        }

        BoundedBlockingBuffer2<String> buffer2 = new BoundedBlockingBuffer2<>();

        for (int i = 0;i < 5;i++){
            int count = i + 1 ;
            new Thread(() -> buffer2.put("item " + count)).start();
        }

        for (int i = 0;i < 5;i++){
            new Thread(buffer2::take).start();
        }

    }
}
