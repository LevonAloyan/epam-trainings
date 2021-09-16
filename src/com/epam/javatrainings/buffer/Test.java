package com.epam.javatrainings.buffer;

public class Test {
    public static void main(String[] args) {
        BoundedBlockingBuffer<Integer> bbb = new BoundedBlockingBuffer<>();
        Thread p1 = new Thread() {
            @Override
            public void run() {
                bbb.put(123);
            }
        };

        Thread p2 = new Thread() {
            @Override
            public void run() {
                bbb.put(456);
            }
        };

        Thread c1 = new Thread() {
            @Override
            public void run() {
                bbb.take(123);
            }
        };

        Thread c2 = new Thread() {
            @Override
            public void run() {
                bbb.take(456);
            }
        };

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(bbb);


    }
}
