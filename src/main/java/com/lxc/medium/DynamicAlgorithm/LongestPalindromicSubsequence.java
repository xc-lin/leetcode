package com.lxc.medium.DynamicAlgorithm;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] opt = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >=0 ; j--) {
                if (i == j) {
                    opt[j][i]=1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j + 1) {
                        opt[j][i]=2;
                        continue;
                    }
                    opt[j][i]= opt[j+1][i-1]+ 2;
                    continue;

                }
                opt[j][i]= Math.max(opt[j][i-1],opt[j+1][i]);
            }
        }
        return opt[0][s.length()-1];

    }


}