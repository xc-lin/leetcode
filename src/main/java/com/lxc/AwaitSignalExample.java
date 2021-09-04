package com.lxc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalExample {
    ReentrantLock lock=new ReentrantLock();
    Condition condition= lock.newCondition();
    public void before() {
        lock.lock();
        System.out.println("before");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition.signalAll();

        lock.unlock();
    }
    public void after(){
        lock.lock();
        try {
            Thread.sleep(5000);
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        AwaitSignalExample awaitSignalExample1=new AwaitSignalExample();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()->awaitSignalExample1.after());
        executorService.execute(()->awaitSignalExample1.before());
        executorService.shutdown();
    }
}
