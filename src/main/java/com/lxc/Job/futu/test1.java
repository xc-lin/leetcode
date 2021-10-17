package com.lxc.Job.futu;

import java.util.Arrays;
import java.util.Stack;
// 1 4 3 5 2
public class test1 {
    public int[] solve(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int length = a.length;
        int[] result = new int[length];
        if (a == null || length == 0) {
            return null;
        }
        int[] max = new int[length + 1];
        // 从后往前记录下最大的那个，但是我们在入栈的时候是从前往后，那么第一个输出的一定是最大的，那个数
        for (int i = length - 1; i >= 0; i--) {
            max[i] = Math.max(a[i], max[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            stack.push(a[i]);
            // 如果当前的数字比后面的数字都要大那么输出，如果后面的比我大那么优先输出最大的
            while (!stack.isEmpty() && stack.peek() > max[i+1]) {
                result[count++] = stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            result[count++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new test1().solve(new int[]{1,4,3,5,2})));
    }
}
