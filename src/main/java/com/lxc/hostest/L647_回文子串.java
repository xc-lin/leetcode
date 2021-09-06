package com.lxc.hostest;

public class L647_回文子串 {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] opt = new boolean[ length][length];
        int count = 0;
        for (int i = length-1; i >=0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 >= j) {
                        count++;
                        opt[i][j] = true;
                        //i需要用到i+1 因此i要从大往小,j要j-1 因此j从小到大
                    } else if (opt[i + 1][j - 1]) {
                        opt[i][j] = true;
                        count++;

                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new L647_回文子串().countSubstrings("aaa"));
    }
}
