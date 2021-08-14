package com.lxc.JZOffer2;

import java.util.Stack;

public class J30_MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public J30_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()||x<=minStack.peek()) {
            minStack.push(x);
        }

        stack.push(x);
    }

    public void pop() {
        int temp =stack.pop();
        if (temp==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return minStack.peek();
    }
}
