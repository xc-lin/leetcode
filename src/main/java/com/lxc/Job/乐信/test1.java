package com.lxc.Job.乐信;

import java.text.DecimalFormat;
import java.util.Arrays;

public class test1 {
    public static String calcPayAmount(String[] skuAmount) {
        if (skuAmount == null || skuAmount.length == 0) {
            return "";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        double[] prices = new double[skuAmount.length];
        for (int i = 0; i < skuAmount.length; i++) {
            prices[i] = Double.parseDouble(skuAmount[i]);
        }
        Arrays.sort(prices);
        double result = 0.0;

        for (int i = prices.length - 1; i >= 0; i -= 2) {
            result += prices[i];

        }

        return df.format(result);
    }

    public static void main(String[] args) {
        System.out.println(calcPayAmount(new String[]{"199.90", "39.90", "29.90", "59.90", "10.0", "200.00", "300"}));
    }
}
