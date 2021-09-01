package com.lxc.hostest;

public class L309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int length=prices.length;
        int[][] opt=new int[length][3];
        // 买入
        opt[0][0]=-prices[0];
        // 卖出
        opt[0][1]=0;
        // 冻结
        opt[0][2]=0;
        for (int i = 1; i < length; i++) {
            // 当前处于买入的阶段前一阶段必须是冻结期或者买入
            opt[i][0]=Math.max(opt[i-1][0],opt[i-1][2]-prices[i]);
            // 当前处于卖出的状态，前一阶段必须是买入的阶段，冻结期之后是不能立马卖出的
            opt[i][1]=opt[i-1][0]+prices[i];
            // 处于冻结期之前必须是卖出或者还是冻结期
            opt[i][2]=Math.max(opt[i-1][2],opt[i-1][1]);
        }
        return Math.max(opt[length-1][0],Math.max(opt[length-1][1],opt[length-1][2]));
    }

    public static void main(String[] args) {
        System.out.println(new L309_最佳买卖股票时机含冷冻期().maxProfit(new int[]{1,2,3,0,2}));
    }
}
