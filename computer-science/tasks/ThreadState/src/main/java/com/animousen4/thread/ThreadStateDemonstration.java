package com.animousen4.thread;

public class ThreadStateDemonstration {

    Thread threadOne;
    Thread threadTwo;

    public void startThreadShow() throws InterruptedException {
        Object lock = new Object();

        threadOne = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        threadTwo = new Thread(() -> {
            synchronized (lock) {

            }

        });

        System.out.println("[1] Thread state before start: " + threadOne.getState());

        threadOne.start();
        threadTwo.start();
        System.out.println("[1] After start: " + threadOne.getState());

        Thread.sleep(500);
        System.out.println("[1] While sleeping: " + threadOne.getState());
        System.out.println("[2] While sleeping: " + threadTwo.getState());

        threadOne.join();
        System.out.println("[1] After join: " + threadOne.getState());


    }

}

