package com.epam.javatrainings.boundedblockingbuffer;

public class BoundedBlockingBuffer<T>{
    private T data;

    public synchronized void put(T data){
        if(this.data==null){
            this.data=data;
            System.out.println(data);
            notifyAll();
        }else {
            try {
                System.out.println("wait");
                wait();
                put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized T tack(){
        if(this.data!=null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello tack");
            T t=data;
            data=null;
            notifyAll();
            return t;
        }else {
            try {
                System.out.println("tack wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tack();
    }
}
