package com.lxc.JZOffer2;

import java.util.Stack;

public class J31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length!=popped.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popCount = 0;
        for (int temp : pushed) {
            stack.add(temp);
            while (!stack.isEmpty()&&stack.peek()==popped[popCount]){
                popCount++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
