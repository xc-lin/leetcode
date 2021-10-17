package com.lxc.Job.电信;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strings=scanner.nextLine().split(" ");
        Deque<Character> optStack = new LinkedList<>();
        Deque<Double> numStack = new LinkedList<>();
        Deque<String> list = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            char c=strings[i].charAt(0);
            if (c=='/'||c=='*'||c=='+'||c=='-'){
                if(optStack.isEmpty()){
                    optStack.push(c);
                    continue;
                }else {
                    char top=optStack.peek();
                    if (value(c)-value(top)>0){
                        optStack.push(c);
                    }else {
                        while (!optStack.isEmpty()&& value(c)-value(optStack.peek())<=0){
                            list.add(String.valueOf(optStack.poll()));
                        }
                        optStack.push(c);
                    }
                }
            }else {
                list.add(strings[i]);
            }
        }
        while (!optStack.isEmpty()){
            list.add(String.valueOf(optStack.poll()));

        }
        while (!list.isEmpty()){
            String temp = list.pop();
            char c= temp.charAt(0);
            if (c=='/'||c=='*'||c=='+'||c=='-') {
                double a1=numStack.poll();
                double a2=numStack.poll();
                double a3= cal(a1,a2,c);
                numStack.push(a3);

            }else {
                numStack.push(Double.parseDouble(temp));
            }
        }
        System.out.println(numStack.peek());

    }
    public static double cal(double a,double b,char opt){
        if (opt=='-'){
            return a-b;
        }
        if (opt=='+'){
            return a+b;
        }
        if (opt=='*'){
            return a*b;
        }
        if (opt=='/'){
            return a/b;
        }
        return 0;
    }
    public static  int  value(char a){
        if (a=='-'){
            return 1;
        }
        if (a=='+'){
            return 1;
        }
        if (a=='*'){
            return 2;
        }
        if (a=='/'){
            return 2;
        }
        return 0;
    }


}
