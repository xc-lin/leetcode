package com.lxc.Job.futu;

import java.util.concurrent.Executors;

public class test3 {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {

        if (v != m + n) {
            return false;
        }
        char c1[] = A.toCharArray();
        char c2[] = B.toCharArray();
        char c3[] = C.toCharArray();
        boolean opt[][] = new boolean[n + 1][m + 1];
        opt[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (c3[i] == c1[i]) {
                opt[i + 1][0] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (c3[i] == c2[i]) {
                opt[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (opt[i][j - 1] && c3[i + j - 1] == c2[j - 1]) {
                    opt[i][j] = true;
                }
                if (opt[i - 1][j] && c3[i + j - 1] == c1[i - 1]) {
                    opt[i][j] = true;
                }
            }
        }

        return opt[n][m];
    }
}
