package com.epam.javatrainings.BoundedBlockBuffer;
public class BoundedBlockBuffer <T> {
    private T value;
    public synchronized T take()
    {
            if(value==null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T temp=value;
            value=null;
            notify();
            return temp;

    }
    public synchronized  void put(T a)
    {
            if(value!=null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            value=a;
            notify();
    }
}
