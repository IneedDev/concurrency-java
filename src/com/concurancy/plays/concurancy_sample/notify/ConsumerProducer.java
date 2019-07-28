package com.concurancy.plays.concurancy_sample.notify;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ConsumerProducer {

    private final static Random generator = new Random();
    private static final Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        int itemCount = 5;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < itemCount; i++) {
                    System.out.println("producer " + i);
                    try {
                        Thread.sleep(Duration.ofSeconds(generator.nextInt(5)).toMillis());
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    synchronized (queue){
                        queue.add("Item no. " + i);
                        //prepare information about new element
                        queue.notify();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                int itemsLeft = itemCount;
                while (itemsLeft>0){
                    String item;
                    synchronized (queue){
                        while (queue.isEmpty()){
                            try {
                                queue.wait();
                            }catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                        }
                        item = queue.poll();
                    }
                    itemsLeft--;
                    System.out.println("Consumer got item: " + item);
                }
            }
        });
        producer.start();
        consumer.start();
    }

}
