package com.lxc.JZOffer;

import java.util.Deque;
import java.util.LinkedList;

public class J59_MaxQueue {
    // 一个队列实现基本的pushback和popfront
    // 和最大滑动窗口一个思想
    // 维护一个双端队列 来实现maxValue的取值
    Deque<Integer> queue;
    Deque<Integer> maxValue;

    public J59_MaxQueue() {
        queue = new LinkedList<>();
        maxValue = new LinkedList<>();
    }

    public int max_value() {
        if (maxValue.isEmpty()){
            return -1;
        }
        // 从双端队列中取队头
        return maxValue.getFirst();

    }
    // 向普通队列和最大队列中插入数据
    public void push_back(int value) {
        queue.addLast(value);
        // 如果队尾有值比较小那就删掉，保持队列是decreasing的
        while (!maxValue.isEmpty() && value > maxValue.getLast()) {
            maxValue.removeLast();
        }
        // 加入队列
        maxValue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int a = queue.pollFirst();
        // 如果有删除的值和当前最大值相同 那就删除这个maxvalue中的队头
        if (a == maxValue.getFirst()) {
            maxValue.removeFirst();
        }
        return a;

    }
}
