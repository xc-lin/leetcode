package com.lxc;

import java.io.*;
import java.util.concurrent.Callable;


public class test extends a {
    static {
//        System.out.println(2222);
    }

    static int a = 3;

    public test() {
        setId(1);
    }

    public test(String name) {
        System.out.println(name);
    }

    public void setId(int id){
        setId(id);
    }

    public int getId(){
        if (id<3){
            return 4;
        }
        return id;
    }
    public void fifnalfuc() {

    }

    public void print() {
        System.out.println("b");
    }

    public void k() {
        this.print();
        print();
    }

    String userName = "A";
    int age = 18;
    public static int count = 1;

    public int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        return 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


    }

    void change(int age, int count, String userName) {
        age++;
        count++;
        System.out.print(age + "," + count + ",");
        userName = "B";
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

class a {
    protected int id;

    public a(){
        id=2;
    }
    public int getId(){
        if (id<3){
            return 3;
        }
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}

class MyException {

}

class Me {
    public void drink() {

    }
}


class test3 extends test2 {
    public test3() {
        super();

    }

    public test3(int set) {
        super(set);
        System.out.println("子类构造函数");
    }


    int ok = 5;

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }


}

class addr {
    String postCode;
}

class student {
    addr ad;
}

class ca implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class test2 implements Cloneable {
    static {
        System.out.println("父类静态代码块");
    }

    static int a = 1;
    int k = 100;

    private static void kk() {
        System.out.println(123123);
    }

    public test2() {

    }

    public test2(int set) {
        k = set;
        System.out.println("父类构造函数");
    }

    {
        System.out.println("父类代码块");
    }

    public final void finalfuc() {
        System.out.println(123);
    }

    public void func2() {
        System.out.println(333);
    }

    @Override
    protected test666 clone() throws CloneNotSupportedException {
        return (test666) super.clone();
    }
}