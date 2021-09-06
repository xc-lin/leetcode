package com.lxc;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.interrupted;

public class test extends a {
    static {
        System.out.println(2222);
    }

    static int a = 3;


    public void fifnalfuc() {

    }
    public void print(){
        System.out.println("b");
    }

    public void k(){
        this.print();
        super.print();
        print();
    }
    public void finalfuc(test2 test) {
        System.out.println(666);
    }

    public void func2() {
        System.out.println(666);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReentrantLock lock=new ReentrantLock();
    }

    private static class A implements Serializable {

        private int x;
        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }
}

class a{
    public void print(){
        System.out.println("a");
    }
}

class test3 extends test2 {
    public test3(int set) {
        super(set);
    }


    int ok = 5;

    static {
        System.out.println(3333);
    }


}

class ca implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class test2 implements Cloneable {
    static {
        System.out.println(1111);
    }

    static int a = 1;
    int k = 100;

    public test2(int set) {
        k = set;
    }

    public final void finalfuc() {
        System.out.println(123);
    }

    public void func2() {
        System.out.println(333);
    }

    @Override
    protected test2 clone() throws CloneNotSupportedException {
        return (test2) super.clone();
    }
}