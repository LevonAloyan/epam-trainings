package com.epam.javatrainings.boundedblockingbuffer;

public class BoundedBlockingBuffer <T>{
    private T data;
    public static volatile boolean isEmpty;

  /*  public static void validateIssEmpty (){
        if(Main.buffer.get(0) == null){
           isEmpty = false ;
        }
        else {
            isEmpty = true;
        }
    }
*/
    public synchronized void put(T data){
       // validateIssEmpty();
        while (!isEmpty){
            System.out.println( "Take the data !!");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            Main.buffer.add(0,data);
            notifyAll();
            isEmpty = false;
          //  validateIssEmpty();

    }

    public synchronized T take (){
      //  validateIssEmpty();
        while (isEmpty){
            System.out.println( "Put the data !!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T myObj = (T) Main.buffer.get(0);
        System.out.println(myObj);
        Main.buffer.add(0,null);
        notifyAll();
        isEmpty = true;
     //   validateIssEmpty();
        return myObj;
    }
}
