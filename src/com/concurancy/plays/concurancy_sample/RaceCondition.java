package com.concurancy.plays.concurancy_sample;

class Counter{
    private int value;

    public void increment(){
        //synchronized (this){
            value+=1;
       // }
    }

    public int getValue(){
        return value;
    }
}
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 100_000; i++) {
                c.increment();
                System.out.println(Thread.currentThread().getName());
                //System.out.println(c.getValue());
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);

        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();
        t6.run();

        t1.join();
        t2.join();
        t3.join();


        System.out.println(c.getValue());

    }
}
