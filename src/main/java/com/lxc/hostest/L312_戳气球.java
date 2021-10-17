package com.lxc.hostest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L312_戳气球 {
    public int[][] rec;
    public int[] val;
    public int maxCoinsBest(int[] nums) {
        int length=nums.length;
        val=new int[length+2];
        for (int i = 1; i < length+1; i++) {
            val[i]=nums[i-1];
        }
        val[0]=val[length+1]=1;
        int opt[][]=new int[length+2][length+2];
        for (int i = length; i >=0; i--) {
            for (int j = i+2; j < length+2; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum=val[k]*val[i]*val[j];
                    sum+=opt[i][k]+opt[k][j];
                    opt[i][j]=Math.max(opt[i][j],sum);
                }
            }
        }
        return opt[0][length+1];
    }


    public int maxCoins(int[] nums) {
        int length=nums.length;
        val=new int[length+2];
        for (int i = 1; i < length+2; i++) {
            val[i]=nums[i-1];
        }
        val[0]=val[length+1]=1;
        rec=new int[length+2][length+2];
        for (int i = 0; i < length+1; i++) {
            Arrays.fill(rec[i],-1);
        }
        return solve(0,length+1);
    }

    public int solve(int left,int right){
        if (right-left<=1){
            return 0;
        }
        if (rec[left][right]!=-1){
            return rec[left][right];
        }
        for (int i = left+1; i < right; i++) {
            int sum=val[left]*val[i]*val[right];
            sum+=solve(left,i)+solve(i,right);
            rec[left][right]=Math.max(rec[left][right],sum);
        }
        return rec[left][right];
    }
}
