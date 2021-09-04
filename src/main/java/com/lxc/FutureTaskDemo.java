package com.lxc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                Thread.sleep(5000);
                return result;
            }
        });
        Thread computeThread=new Thread(futureTask);
        computeThread.start();
        Thread otherThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("other task is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());

    }
}
