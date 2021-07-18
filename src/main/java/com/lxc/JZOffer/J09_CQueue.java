package com.lxc.JZOffer;

import java.util.Stack;

public class J09_CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public J09_CQueue() {
        stack2=new Stack<>();
        stack1=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size()==0){
            return -1;
        }
        return stack2.pop();

    }
}
