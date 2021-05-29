package edu.citytech.cst.s23778215.ds;

import java.util.function.Consumer;

public class Counter {

    public static void count(int start, int end, Consumer<Integer> consumer){

        if(start > end)
            return;
       // System.out.println("Counter..:"+start);
        consumer.accept(start);
        count(++start,end,consumer);
    }
}
