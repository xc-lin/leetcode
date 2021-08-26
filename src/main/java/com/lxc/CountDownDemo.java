package com.lxc;

import java.util.concurrent.*;

public class CountDownDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count=5;
        CountDownLatch countDownLatch =  new CountDownLatch(count);

        for (int i = 0; i < 5; i++) {
            new Thread(new sub2(countDownLatch,1000*(i+1))).start();
        }
//        Thread.sleep(10000);
        countDownLatch.await();
        System.out.println("main");

    }
}

class sub2 implements Runnable{
    private CountDownLatch countDownLatch;
    private long workTime ;
    public sub2(CountDownLatch countDownLatch,long workTime){
        this.countDownLatch=countDownLatch;
        this.workTime=workTime;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(workTime);
            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
