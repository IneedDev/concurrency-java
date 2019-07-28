package com.concurancy.plays.concurancy_sample.task;

class ReversNestedThreads extends Thread{
    private final int number;


    ReversNestedThreads(int number){
        this.number = number;
    }

    @Override
    public void run() {
        if(number>0){
            ReversNestedThreads reversNestedThreads = new ReversNestedThreads(number-1);
            reversNestedThreads.start();
            try {
                reversNestedThreads.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(getName());
        }
    }
}

public class ReverseNumbers {

    public static void main(String[] args) {
        startReversThreads(3);
    }

    static void startReversThreads(int number){
        new ReversNestedThreads(number).start();
    }
}
