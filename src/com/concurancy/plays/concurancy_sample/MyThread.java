package com.concurancy.plays.concurancy_sample;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Run() is called");
    }
}
