package com;

public class Main2 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Counter counter=new Counter();
        for (int i = 0; i < 1000000000; i++) {
            counter.increase();
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    static class Counter{
          int i;
          void increase(){i++;}
    }
}
