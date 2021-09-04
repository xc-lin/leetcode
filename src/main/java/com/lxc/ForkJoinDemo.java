package com.lxc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Integer> {
    int threshold=5;
    int first;
    int last;
    public ForkJoinDemo(int first,int last){
        this.first=first;
        this.last=last;
    }

    @Override
    protected Integer compute() {
        int result=0;
        if (last-first<=threshold){
            for (int i = first; i < last; i++) {
                result+=i;
            }
        }else {
            int middle =first+(last-first)/2;
            ForkJoinDemo forkJoinDemo1=new ForkJoinDemo(first,middle);
            ForkJoinDemo forkJoinDemo2=new ForkJoinDemo(middle+1,last);
            forkJoinDemo1.fork();
            forkJoinDemo2.fork();
            result=forkJoinDemo1.join()+forkJoinDemo2.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinDemo forkJoinDemo=new ForkJoinDemo(0,10000);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        Future result=forkJoinPool.submit(forkJoinDemo);
        System.out.println(result.get());
    }


}
