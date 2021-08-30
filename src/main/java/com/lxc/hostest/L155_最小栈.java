package com.lxc.hostest;

import java.util.Deque;
import java.util.LinkedList;

public class L155_最小栈 {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public L155_最小栈() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            // 防止 如果有两个一样的数，如果不push进去那么在删除第一个的时候会导致minStack里的最小值不正确
        } else if (minStack.peek() >= val) {
            minStack.push(val);
        }

    }

    public void pop() {
        int temp = stack.poll();
        if (minStack.peek() == temp) {
            minStack.poll();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
