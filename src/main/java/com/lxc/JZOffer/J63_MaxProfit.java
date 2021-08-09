package com.lxc.JZOffer;

public class J63_MaxProfit {
    public int maxProfit(int[] prices) {
        int opt[] = new int[prices.length];
        int min = 0;
        if (prices.length != 0) {
            min = prices[0];
        }

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && min > prices[i - 1]) {
                min = prices[i - 1];
            }

            opt[i] = prices[i] - min > 0 ? prices[i] - min : 0;
        }
        int result = 0;
        for (int profit : opt) {
            if (profit > result) {
                result = profit;
            }
        }
        return result;
    }

    public int maxProfitBetter(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
            // 可以把当前价格和min相比的原因是 如果向前价格更低， 那么在算result的时候必定结果就是0 因为当天卖出当天买入
            // 而且result 只保留当前最大的那个，所以即使最后的那个最小 那么算出来一定是0 要么一定是>0的数不可能小于0
            min = Math.min(min, prices[i]);
            // 省略的建表的过程，节省了空间复杂度
            result = Math.max(result,prices[i] - min);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new J63_MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
