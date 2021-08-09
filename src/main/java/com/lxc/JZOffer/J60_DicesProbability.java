package com.lxc.JZOffer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class J60_DicesProbability {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     *
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        // 这是初始的概率 都是1/6
        double opt[] = new double[6];
        // 首先填充初始概率
        Arrays.fill(opt, 1.0/6.0);
        // 此题主要的思想是因为前一个骰子的概率只会影响到后一个骰子的6个概率
        // 然后上一个骰子的第i个点数只会影响到下一个骰子的第i个和第i+1个骰子点数的概率
        // 比如上一个骰子得出的点数分别是1 2 3 4 5 6
        // 点数为1的哪一个概率 他只会影响到下一个骰子点数2 3 4 5 6 7 后面的他无法影响因为自己就是1 下一个骰子最大是6 6+1=7
        // 所以他只能影响到i+6
        // 比如2 也只能影响到3...8
        // 遍历得到上一轮的概率
        for (int i = 2; i <= n; i++) {
            // 骰子点数总和的范围是n...6n
            double temp[] = new double[5 * i + 1];
            for (int j = 0; j < opt.length; j++) {
                // 对于每一个骰子点数都加起来
                // 不断地累加到 下一轮的概率
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += opt[j]/6;
                }
            }
            opt = temp;


        }
        return opt;
    }

    public static void main(String[] args) {
        System.out.println(new J60_DicesProbability().dicesProbability(3));
    }
}
