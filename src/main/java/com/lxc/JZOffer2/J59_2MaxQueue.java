package com.lxc.JZOffer2;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class J59_2MaxQueue {
    Deque<Integer> maxQueue;
    Deque<Integer> queue;

    public J59_2MaxQueue() {
        maxQueue = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public int max_value() {
        if (!maxQueue.isEmpty()) {
            return maxQueue.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty()) {
            if (maxQueue.getLast() < value) {
                maxQueue.removeLast();
            }else {
                break;
            }
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        int front = -1;
        if (!queue.isEmpty()) {
            front = queue.removeFirst();
            if (maxQueue.getFirst() == front) {
                maxQueue.removeFirst();
            }
        }
        return front;
    }
}
