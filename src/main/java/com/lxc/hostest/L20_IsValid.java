package com.lxc.hostest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20_IsValid {
    public boolean isValid(String s) {
        if (s.length()%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();
        char c[]=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(stack.peek())){
                stack.push(c[i]);
            }else {
                if (stack.isEmpty()||map.get(stack.pop())!=c[i]){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
