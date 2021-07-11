package com.lxc.medium.DynamicAlgorithm;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] opt = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    opt[j][i] = true;
                    continue;
                }
                if ( (s.charAt(i) == s.charAt(j))) {
                    if (i == j + 1) {
                        opt[j][i] = true;
                        continue;
                    }
                    if ((opt[j + 1][i - 1]))
                        opt[j][i] = true;
                }
            }
        }
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (opt[i][j] == true && (j - i) > (right - left)) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
