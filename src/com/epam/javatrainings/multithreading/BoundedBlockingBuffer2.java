package com.epam.javatrainings.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingBuffer2<T> {
   private T data;

   private final Lock lock = new ReentrantLock(true);
   Condition condition = lock.newCondition();

   public void put(T t){

       lock.lock();
       try {
           if (data == null) {
               data = t;
               System.out.println("Producer " + data);
               condition.signalAll();
           }else {
               System.out.println("Producer is waiting");
               condition.await();
               put(t);
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           lock.unlock();
       }
   }

   public void take(){

       lock.lock();
       try {
           if (data != null){
               System.out.println("Consumer " + data);
               data = null;
               condition.signalAll();
           }else{
               System.out.println("Consumer is waiting" );
               condition.await();
               take();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           lock.unlock();
       }
   }


}
