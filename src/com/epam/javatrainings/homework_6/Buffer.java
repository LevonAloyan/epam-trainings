package com.epam.javatrainings.homework_6;

public class Buffer <T>{
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public synchronized void  put(T obj) {
        if (this.obj != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.obj = obj;
            notify();

    }
    public synchronized T take(){
         if(this.obj == null){
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
             T temp = obj;
             obj = null;
             notify();
             return temp;

    }
}
