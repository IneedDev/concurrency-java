package com.concurancy.plays;

public class Main {

public static class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello world from Thread implemented Runnable" );
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }
}
    public static void main(String[] args) {
        //System.out.println("Hello World!");

       // System.out.println("Output from Thread class");
        Thread thread1= new MyThread();
        System.out.println(thread1.getState().name());
        //System.out.println(thread1.getName());
        thread1.start();
        System.out.println("after start" + thread1.getState().name());

        Thread thread2 = new Thread(new MyRunnable());
        //System.out.println(thread2.getName());
        thread2.start();
        System.out.println("thread 1");
        System.out.println(thread1.getState().name());
        thread1.stop();
        System.out.println("thread 2");
        System.out.println(thread2.getState().name());
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + " " + i){
                public void run(){
                    System.out.println("Thread " + Thread.currentThread().getName());

                }
            }.start();

        }

    }

}
