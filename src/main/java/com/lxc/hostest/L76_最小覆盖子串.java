package com.lxc.hostest;

import java.util.HashMap;
import java.util.Map;

public class L76_最小覆盖子串 {
    Map<Character, Integer> sub = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int left = -1;
    int right = -1;
    int length=Integer.MAX_VALUE;
    public String minWindow(String s, String t) {

        int tempLeft = 0;
        int tempRight = -1;


        for (int i = 0; i < t.length(); i++) {
            sub.put(t.charAt(i), sub.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 持续移动窗口右边界
        while (tempRight < s.length()) {
            tempRight++;
            window.put(s.charAt(tempRight), window.getOrDefault(s.charAt(tempRight), 0) + 1);
            // 查看此时是否满足条件
            // 如果不满足，窗口右边界继续右移
            while (check() && tempLeft <= tempRight) {
                // 满足的话，看窗口长度是不是变小了 如果变小了就更新全局左右边界
                if (tempRight-tempLeft+1<length) {
                    left = tempLeft;
                    right = tempRight;
                    length=tempRight-tempLeft+1;
                }
                // 这里要尝试减小窗口
                // 窗口的左端包含有t的字符且
                if (sub.containsKey(s.charAt(tempLeft))) {
                    window.put(s.charAt(tempLeft),window.get(s.charAt(tempLeft))-1);
                }
                tempLeft++;
            }
        }
        return length==Integer.MAX_VALUE?"":s.substring(left,right+1);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : sub.entrySet()) {
            if (window.getOrDefault(entry.getKey(),0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L76_最小覆盖子串().minWindow("a","a"));
    }
}
