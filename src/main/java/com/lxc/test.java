package com.lxc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class test extends test2{
    static int a =3;

    public test(int set) {
        super(set);
    }
    public void finalfuc(){

    }
    public void fuc(test2 test){
        test=new test2(-100);
        System.out.println(test.k);
    }
    public static void main(String[] args) {
        test t=new test(10);
        test2 t2=new test2(100);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < 6; i++) {
            map.put(i,i);
        }
        Iterator iter =map.keySet().iterator();
        while (iter.hasNext()){

            System.out.println(iter.next());
            iter.remove();

        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(list.get(10));


//        ReentrantLock lock=new ReentrantLock();
//        Condition c= lock.newCondition();
//        try {
//            c.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Condition c1 = lock.newCondition();
//        for (int i = 0; i <4 ; i++) {
//            new Thread(()->{
//                System.out.println();
//            }).start();
//        }
    }
}

class test2 {
    static int a =1;
    int k=100;
    public  test2(int set){
        k=set;
    }
    protected void finalfuc(){

    }

}