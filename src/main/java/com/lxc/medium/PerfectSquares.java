package com.lxc.medium;

public class PerfectSquares {
    public int numSquares(int n) {
        int result = 0;
        int temp = 1;
        while (temp > 0) {
            temp = (int) Math.sqrt(n);
            System.out.println(temp);
            result++;
            n -= temp * temp;
        }

        return result;
    }
}
