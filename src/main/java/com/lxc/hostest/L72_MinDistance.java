package com.lxc.hostest;

public class L72_MinDistance {
    public static int minDistance(String word1, String word2) {
        int opt[][] = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word2.length()+1; i++) {
            opt[0][i]=i;
        }
        // 原串为0 删除
        for (int i = 0; i < word1.length()+1; i++) {
            opt[i][0]=i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                int insert, delete, replace = 0;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    opt[i][j] = opt[i - 1][j - 1];
                } else {
                    delete = opt[i - 1][j] + 1;
                    insert = opt[i][j - 1]+1;
                    replace = opt[i - 1][j - 1] + 1;
                    opt[i][j] = Math.min(Math.min(delete, insert), replace);
                }
            }
        }
        return opt[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("","a"));
    }
}
