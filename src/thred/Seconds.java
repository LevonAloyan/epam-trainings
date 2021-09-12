package thred;

import java.util.Scanner;

public class Seconds implements Runnable {
    @Override
    public void run() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Input hours");
        int x = cs.nextInt();
        System.out.println("Inpute time");
        int y = cs.nextInt();
//        String minit;
//        String hours;
        for (int i = x; i >= 0; i--) {
            for (int j = y; j >= 0; j--) {
                if (j == 0) {
                    y = 60;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String hours= String.valueOf(i);
                String minit= String.valueOf(j);
                if (i<10) {
                    hours="0"+i;
                }
                if(j<10){
                    minit="0"+j;
                }
                    System.out.println(hours+":"+minit);

            }

        }
    }


    public static void main(String[] args) {
        Seconds seconds = new Seconds();
        seconds.run();

    }
}
