package com.epam.javatrainings.thread.blockingBuffer;

/**
 * Created by Hayk on 16.09.2021.
 */
public class BoundedBlockingBuffer<T> {
    private T value;

    public  synchronized void put(T value){
        while (this.value!=null){
            try {
               wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value=value;
        System.out.println("Put value: "+value);
        notify();
    }

    public  synchronized T peek(){
        T result;
        while (this.value==null){
            try {
              wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            result=this.value;
            this.value=null;
            System.out.println("Peek value: "+result);
            notify();
        return result;
    }
}
