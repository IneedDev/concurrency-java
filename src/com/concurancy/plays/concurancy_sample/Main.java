package com.concurancy.plays.concurancy_sample;

public class Main {

    public static void main(String[] args) {

        System.out.println("MT - Start");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T0 start");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("T0 " + i);
                }
                System.out.println("T0 stop ");
            }
        });

        // differance start and call methods
        MyThread myThread = new MyThread();
        System.out.println("wee call start() and run in the background");
        myThread.start();

        thread.start(); // start method create and run() is executed
       // thread.start();  can not be call twice
        //thread.run();
        thread.run();


    }
}
