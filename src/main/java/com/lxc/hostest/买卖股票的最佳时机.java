package com.lxc.hostest;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result=0;
        for (int i = 0; i < prices.length; i++) {
            min=Math.min(min,prices[i]);
            result=Math.max(prices[i]-min,result);
        }
        return result;

    }
}
