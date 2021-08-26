package com.lxc;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Runnable run= new run();
//        Thread t1= new Thread(run);
        Future future=executorService.submit(run);
        future.get();
        System.out.println("main");

//        t1.setDaemon(true);
//        t1.start();

    }
}
class run implements Runnable{

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(123);
    }
}
