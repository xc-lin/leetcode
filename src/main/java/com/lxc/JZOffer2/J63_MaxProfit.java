package com.lxc.JZOffer2;

public class J63_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0||prices.length==1){
            return 0;
        }
        int opt[]=new int[prices.length];
        opt[0]=prices[0];
        int result=0;
        int min=prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<min){
                min=prices[i];
            }
            result=Math.max(result,prices[i]-min);
        }
        return result;
    }
}
