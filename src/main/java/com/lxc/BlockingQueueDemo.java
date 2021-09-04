package com.lxc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("producer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("producer");
        }
    }

    static class consumer extends Thread {
        @Override
        public void run() {
            try {
                String producer = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer=new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            consumer c=new consumer();
            c.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer=new Producer();
            producer.start();
        }

    }
}
