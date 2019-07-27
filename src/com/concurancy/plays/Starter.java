package com.concurancy.plays;

public class Starter {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("123456-789", 1000);

        //annponymous class

//        Thread mythread1 = new Thread(){
//            public void run(){
//                bankAccount.deposit(300.00);
//                bankAccount.withdraw(100.00);
//                System.out.println(currentThread().getName() +" " +bankAccount.getBalance());
//            }
//        };
//        Thread mythread2 = new Thread(){
//            public void run(){
//                bankAccount.deposit(200.50);
//                bankAccount.withdraw(100.00);
//                System.out.println(currentThread().getName() +" " +bankAccount.getBalance());
//            }
//        };
//        mythread1.start();
//        mythread2.start();
//
//        System.out.println("final balance" + " " + bankAccount.getBalance());

        // new way with runnable

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300);
                bankAccount.withdraw(50);
               // System.out.println("thread-0 " + bankAccount.getBalance());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(200.45);
                bankAccount.withdraw(100);
                //System.out.println("thread-1 " + bankAccount.getBalance());
            }
        });
        //thread1.start();
        thread1.run();
        System.out.println(thread1.getName() + "  " +bankAccount.getBalance());

        //thread2.start();
        thread2.run();
        System.out.println(thread2.getName() + "  " +bankAccount.getBalance());

        System.out.println("main balance" + " " + bankAccount.getBalance());

    }
}
