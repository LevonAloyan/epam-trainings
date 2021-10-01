package com.epam.javatrainings.thread_2;

public class Main {
    public static void main(String[] args) {
        BlockingBuffer<Person> blockingBuffer = new BlockingBuffer<>();

        Person person1 = new Person("Sevak", 1);
        Person person2 = new Person("Anna", 2);

        //?
        BlockingBufferedThread<String> thread1
                = new BlockingBufferedThread(person2.getId(), blockingBuffer);
        BlockingBufferedThread<Person> thread2
                = new BlockingBufferedThread(person1.getName(), blockingBuffer);

        thread1.start();
        thread2.start();

        //main thread's waiting for all threads finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Final");
        }
    }
}
