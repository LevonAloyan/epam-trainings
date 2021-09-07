package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.*;

public class PalmettoPizzeriaCashDesk {


    private ArrayList<Order> order_list;
    PalmettoPizzeriaCashDesk(){
        order_list=new ArrayList<>();
    }
    public void addOrder(String name){
        order_list.add(new Order(name));
    }
    public Order getOrder(int i) throws ArrayIndexOutOfBoundsException
    {
        return order_list.get(i);
    }
}
