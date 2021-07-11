package com.lxc.medium.DynamicAlgorithm;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        boolean opt[][] = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if ((s.charAt(i) == s.charAt(j)) && ((i - j <= 1) || opt[j + 1][i - 1])) {
                    opt[j][i] = true;
                    result++;
                }
            }
        }
        return result;

    }

}