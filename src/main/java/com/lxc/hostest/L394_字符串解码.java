package com.lxc.hostest;

import java.util.Deque;
import java.util.LinkedList;

public class L394_字符串解码 {
    public String decodeString(String s) {
        char cs[] = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                stack.push(cs[i]);
            } else if (cs[i] == '[') {
                stack.push('[');
            } else if (cs[i] == ']') {
                StringBuffer temp = new StringBuffer();
                while (!stack.isEmpty()) {
                    char c = stack.poll();
                    if (c == '[') {
                        break;
                    }
                    temp.insert(0,c);
                }
                int times=0;
                int count=1;
                while (!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9'){
                    times=times+(stack.poll() - '0')*count;
                    count*=10;
                }
                for (int j = 0; j < times; j++) {
                    if (stack.isEmpty()) {
                        sb.append(temp);
                    }else {
                        for (int k = 0; k < temp.length(); k++) {
                            stack.push(temp.charAt(k));
                        }
                    }
                }
            } else if (!stack.isEmpty()) {
                stack.push(cs[i]);
            } else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L394_字符串解码().decodeString("100[l]"));
    }
}
