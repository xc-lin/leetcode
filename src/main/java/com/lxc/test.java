package com.lxc;

import java.util.HashMap;
import java.util.PriorityQueue;

public class test {
    static int a =10;
    static {
        System.out.println(a);
        System.out.println("stack 语句快");
    }
    int b=20;
    public test(){
        a=10;
        System.out.println(b);
    }

    public static void main(String[] args) {
        new test();
    }
}
