package com.concurancy.plays.concurancy_sample.task;


public class Main {

    public static void main(String[] args) {

        //startNewThread(5);
        System.out.println("------");
    }


    public static void startNewThread(int number){
        for (int i = 0; i < number; i++) {
             Thread thread = new Thread(new Runnable() {
                 @Override
                 public void run() {

                 }
             });
            System.out.println(thread.getName());
        }
    }
}
