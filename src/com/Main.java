package com;

public class Main {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Counter counter=new Counter();
        for (int i = 0; i < 1000000000; i++) {
            counter.increase();
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    static class Counter{
        volatile int i;
        synchronized void increase(){i++;}
    }
}
