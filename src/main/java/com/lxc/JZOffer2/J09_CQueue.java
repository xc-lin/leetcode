package com.lxc.JZOffer2;

import java.util.Stack;

public class J09_CQueue {
    Stack<Integer> stackHead;
    Stack<Integer> stackTail;

    public J09_CQueue() {
        stackHead = new Stack<>();
        stackTail = new Stack<>();
    }

    public void appendTail(int value) {
        if (stackHead.isEmpty()) {
            stackHead.add(value);
        } else {
            stackTail.add(value);
        }
    }

    public int deleteHead() {
        if (stackHead.isEmpty()) {
            return -1;
        }
        int head = stackHead.pop();
        if (stackHead.isEmpty()) {
            while (!stackTail.isEmpty()) {
                stackHead.add(stackTail.pop());
            }
        }
        return head;
    }

    public int deleteHeadBetter() {
        if (stackHead.isEmpty()) {
            return -1;
        }
        if (stackHead.size() > 1) {
            return stackHead.pop();
        }
        int head = stackHead.pop();
        while (!stackTail.isEmpty()) {
            stackHead.add(stackTail.pop());
        }

        return head;
    }
}
