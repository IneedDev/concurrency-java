package com.concurancy.plays.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // lambda expresion

//        Runnable runnableTask = () -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };

        //anonymous class
        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    return "Tasks execution";
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return null;
            }
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        System.out.println(callableTasks);

        //executorService.execute(runnableTask);
        executorService.submit(runnableTask);
        executorService.submit(runnableTask);

        System.out.println(executorService.submit(runnableTask));

        System.out.println(executorService);

        executorService.shutdown();

        System.out.println(executorService);






    }
}
