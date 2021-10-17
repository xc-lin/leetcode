package com.lxc.hostest;

public class L10_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        boolean[][] opt = new boolean[length1+1][length2+1];
        opt[0][0]=true;

        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        for (int i = 1; i < length1; i++) {
            opt[i][0]=false;
        }
        for (int i = 1; i < length2; i++) {
            if (charP[i-1]=='*'){
                opt[0][i]=opt[0][i-1];
            }
        }
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {

                if (charS[i - 1] == charP[j - 1] || charP[j - 1] == '.') {
                    opt[i][j] = opt[i - 1][j - 1];
                } else if (charP[j - 1] == '*') {
                    if (charS[i - 1] == charP[j - 2] || charP[j - 2] == '.') {
                        opt[i][j] = opt[i][j - 2] || opt[i - 1][j - 2] || opt[i - 1][j];
                    } else {
                        opt[i][j] = opt[i][j - 2];
                    }
                }

            }
        }
        return opt[length1][length2];
    }
}
