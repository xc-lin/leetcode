package com.lxc.Job.zoom;

import java.util.Deque;
import java.util.LinkedList;

public class test1 {
    public static boolean isValidStr (String str) {
        if (str==null||str.length()==0){
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        char cs[] = str.toCharArray();
        for (char c : cs) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '<') {
                stack.push('>');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.poll() != c) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidStr("()<)"));
    }
}
