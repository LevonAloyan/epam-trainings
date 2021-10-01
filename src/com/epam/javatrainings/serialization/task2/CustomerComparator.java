package com.epam.javatrainings.serialization.task2;

import java.util.Comparator;

public class CustomerComparator implements Comparator <Customer>{
    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getScore() > o2.getScore()){
            return 1;
        }else if(o1.getScore() < o2.getScore()){
            return -1;
        }
        return 0;
    }
}
