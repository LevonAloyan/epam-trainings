package com.epam.javatrainings.buffer;

import java.util.List;

public class BoundedBlockingBuffer <T>{
    private T obj;



     public synchronized void put (T newObject){
         if (this.obj != null){
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }notify();
         this.obj = newObject;

     }
     public synchronized void take(T removeObject){
        if (this.obj == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }notify();
        removeObject = obj;
        obj = null;

     }

    @Override
    public String toString() {
        return "BoundedBlockingBuffer{" +
                "obj=" + obj +
                '}';
    }
}
