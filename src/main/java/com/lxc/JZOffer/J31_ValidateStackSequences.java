package com.lxc.JZOffer;

import java.util.Stack;

public class J31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popCount = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            if (pushed[i] == popped[popCount]) {

                stack.pop();
                popCount++;
                while (!stack.isEmpty() && stack.peek() == popped[popCount]) {
                    stack.pop();
                    popCount++;
                }

            }

        }
        System.out.println(popCount);
        while (!stack.isEmpty()) {
            if (popped[popCount] != stack.pop()) {
                return false;
            }
            popCount++;
        }
        if (popCount != popped.length) {
            return false;
        }
        return true;
    }

    public boolean validateStackSequencesBest(int[] pushed, int[] popped) {
        // 使用一个栈来模拟
        Stack<Integer> stack = new Stack<>();
        // 作为popped的指针
        int popCount = 0;
        // 向模拟栈中压入pushed的元素
        for (int i = 0; i < pushed.length; i++) {
            // 压入元素
            stack.push(pushed[i]);
            // 如果stack不为空，且当前栈顶和popped的当前元素相同，说明此时应该pop，因为没有重复元素
            // 如果当前压入的元素和当前pop的元素相同，就pop，重复因为可以压入以后，继续pop
            while (!stack.isEmpty() && stack.peek() == popped[popCount]) {
                stack.pop();
                popCount++;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
