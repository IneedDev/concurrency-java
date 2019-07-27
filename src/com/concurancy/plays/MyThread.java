package com.concurancy.plays;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Thread Hello World");
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }
}