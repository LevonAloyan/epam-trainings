package com.epam.javatrainings.buffer;

public class BoundedBlockingBuffer <T> {

    private T data;

    public synchronized  T take(String name) {
        while (data == null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Taked Data (by " + name + ") : " + data);
        T tmp = data;
        data = null;
        notifyAll();
        return tmp;
    }
    public synchronized void put(T value,String name){
        while(data!=null){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        data=value;
        System.out.println("Puted Data (by " + name + ") : " +data);
        notifyAll();
    }
}
