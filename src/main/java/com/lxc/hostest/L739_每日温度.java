package com.lxc.hostest;

import java.util.*;

public class L739_每日温度 {
    public int[] dailyTemperaturesStack(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = i - index;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<temp> queue = new PriorityQueue<>(new Comparator<temp>() {
            @Override
            public int compare(temp o1, temp o2) {
                return o2.temperature - o1.temperature;
            }
        });
        for (int i = 0; i < temperatures.length; i++) {
            queue.offer(new temp(temperatures[i], i));
        }
        int[] result = new int[temperatures.length];
        int lastIndex = -1;
        while (!queue.isEmpty()) {
            temp a = queue.poll();
            if (a.index > lastIndex) {
                result[a.index] = 0;
            } else {
                result[a.index] = lastIndex - a.index;
            }
            lastIndex = a.index;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L739_每日温度().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

class temp {
    int temperature;
    int index;

    public temp(int temperature, int index) {
        this.temperature = temperature;
        this.index = index;
    }
}
