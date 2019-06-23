package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread");
        AnotherThread anotherThread = new AnotherThread();
        //anotherThread.run();
        //invoking thread is controlled by system order is random

        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        // below method will run current Thread what is not good way better use start()
        //anotherThread.run();

        //------------

        //System.out.println("Hello again from main thread");
        // it's not possible to run start() without creating new Thread instance
        // start() creats  new Thread and call run() method
        //anotherThread.start();
        //System.out.println("--------------------");
        //anonymous class before need to have new thread instance
        // new thread running in the background

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable()){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED +"Another thread terminated or timed out, so I'm running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I could not wait after all. I was interrupted");
                }
            }
        };
        myRunnableThread.start();



        //InterruptedException - we invoke return from catch
        //this interruption while 3sec sleep cause catch
        //anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
