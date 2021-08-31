package com.lxc.hostest;

import java.util.Map;

public class L279_完全平方数 {
    // 就是最后一个数取多少，前面取多少取决于前面的opt
    // opt[n] = min{opt[n-j*j]}+1
    // 只用关心现在最后一个取哪个完全平方数
    // 前面的都已经是最佳的了
    public int numSquares(int n) {
        int[] opt=new int[n+1];
        opt[0]=0;
        opt[1]=1;
        for (int i = 2; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                // 选择当前拿几块的硬币（j*j）
                min= Math.min(opt[i-j*j]+1,min);
            }
            opt[i]=min;
        }
        return opt[n];

    }

    public static void main(String[] args) {
        System.out.println(new L279_完全平方数().numSquares(12));
    }
}
