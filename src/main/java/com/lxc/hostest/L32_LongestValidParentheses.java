package com.lxc.hostest;

import java.util.Stack;

public class L32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char c[] = s.toCharArray();
        Stack<Integer> stack = new Stack();
        // 刚开始先扔一个进去
        stack.push(-1);
        int length = 0;
        int Maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 遇到左括号就入栈
            if (c[i] == '(') {
                stack.push(i);
            } else {
                // 当输入为右括号就出栈
                int temp = stack.pop();
                // 因为如果都是匹配的，左括号和右括号一定是匹配的
                // 当栈为空，一定多了一个右括号已经和前面的断开了
                if (stack.isEmpty()) {
                    //将这个右括号放入栈
                    stack.push(i);
                } else {
                    // 每次拿出来都与栈顶比较一下 栈顶元素只有两种可能
                    // 1、上一个左括号的位置 这个和之前已经断开 所以直接减一下就好了
                    // 2、上一个断开的右括号 要么是-1 要么是上一个断开的右括号位置
                    Maxlength=Math.max(Maxlength,i-stack.peek());
                }
            }
        }
        return Maxlength;
    }

    public static void main(String[] args) {
        System.out.println(new L32_LongestValidParentheses().longestValidParentheses("(()"));
    }
}
