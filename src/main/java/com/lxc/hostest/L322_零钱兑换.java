package com.lxc.hostest;

import java.util.Arrays;

public class L322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] opt=new int[amount+1];
        opt[0]=0;
        for (int i = 1; i < amount+1; i++) {
            int min=amount+1;
            for (int j = 0; j < coins.length; j++) {

                if (i-coins[j]>=0){
                    min=Math.min(min,opt[i-coins[j]]+1);
                }
            }
            opt[i]=min;
        }
        int value=opt[amount];
        if (value>amount){
            return -1;
        }
        return value;
    }

    public static void main(String[] args) {
        new L322_零钱兑换().coinChange(new int[]{2},3);
    }

}
