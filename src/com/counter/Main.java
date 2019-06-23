package com.counter;

public class Main {
    public static void main(String[] args) {

        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread countdownThread1 = new CountdownThread(countdown1);
        countdownThread1.setName("Thread 1");
        CountdownThread countdownThread2 = new CountdownThread(countdown2);
        countdownThread2.setName("Thread 2");

        countdownThread1.start();
        countdownThread2.start();
    }
}
    class Countdown{

    //instance variable  are stored in HEAP and are shared between threads
    private int i;

        public  synchronized void doCountdown(){
            String color;

            switch (Thread.currentThread().getName()){
                case "Thread 1":
                    color = ThreadColor.ANSI_CYAN;
                    break;
                case "Thread 2":
                    color = ThreadColor.ANSI_PURPLE;
                    break;
                    default:
                        color = ThreadColor.ANSI_GREEN;
            }
            for (i=10; i>0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
            }
        }
    }
    class CountdownThread extends Thread{
        private Countdown thredCountdown;

        public CountdownThread (Countdown countdown){
            thredCountdown = countdown;
        }

        public void run(){
            thredCountdown.doCountdown();
        }
    }

