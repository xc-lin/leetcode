package com.lxc;

public class 数位之和 {
    public int sum(int x) {
        int result = 0;
        while (x != 0) {
            result+=x%10;
            x/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 数位之和().sum(111));
    }
}
