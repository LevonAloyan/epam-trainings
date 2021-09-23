package com.epam.javatrainings.homework_6;

public class Buffer <T>{
    private T obj;


    public synchronized void  put(T obj) {
        while (this.obj != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.obj = obj;
            notifyAll();

    }
    public synchronized T take(){
         while(this.obj == null){
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
             T temp = obj;
             obj = null;
             notifyAll();
             return temp;

    }
}
