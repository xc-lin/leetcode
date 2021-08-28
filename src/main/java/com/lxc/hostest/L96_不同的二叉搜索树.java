package com.lxc.hostest;

public class L96_不同的二叉搜索树 {
    // 1 2 3 4 5 6 7
    // 假设以3为根 二叉树的个数为 opt[2]*opt[4] 一共有7种根的种类
    // 因此总的就是sum(opt[i-1]*opt[n-i])
    public int numTrees(int n) {
        int opt[]=new int[n+1];
        opt[0]=0;
        opt[1]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j <=i; j++) {
                opt[i]+=opt[j-1]*opt[i-j];
            }

        }
        return opt[n];
    }
}
