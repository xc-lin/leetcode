package com.lxc.Job.Microsoft;

public class test1 {
    public static String solution(String riddle) {
        char[] chars = riddle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                char pre = '-';
                char next = '-';
                if (i != 0) {
                    pre = chars[i - 1];
                }
                if (i != chars.length - 1) {
                    next = chars[i + 1];
                }
                for (int j = 0; j < 26; j++) {
                    if ('a' + j != pre && 'a' + j != next) {
                        chars[i] = (char) ('a' + j);
                        break;
                    }
                }

            }
        }
        return chars.toString();
    }

    public static void main(String[] args) {
        System.out.println(test1.solution("ab?ac?"));
    }
}
