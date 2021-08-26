package com.lxc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count=5;
        CyclicBarrier cyclicBarrier =  new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程结束");
            }
        });

        for (int i = 0; i < 10; i++) {
            new Thread(new sub3(cyclicBarrier,1000*(i+1))).start();
        }
//        Thread.sleep(10000);
//        countDownLatch.await();
        System.out.println("main");

    }
}

class sub3 implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private long workTime ;
    public sub3(CyclicBarrier cyclicBarrier,long workTime){
        this.cyclicBarrier=cyclicBarrier;
        this.workTime=workTime;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(workTime);
            System.out.println(Thread.currentThread().getName());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"结束");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
