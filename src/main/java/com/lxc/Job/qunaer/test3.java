package com.lxc.Job.qunaer;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class test3_1 {
    /* Write Code Here */
    public int solution(String str) {
        int length = str.length();
        boolean opt[][] = new boolean[length][length];
        int count = 0;

        for (int i = 0; i < length - 4; i++) {
            int maxN = (length - i + 2) / 3;
            for (int j = 2; j <= maxN; j++) {
                if (judge(str.substring(i, i + 3 * j - 2))) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean judge(String str) {
        int length = str.length();
        char[] S = str.toCharArray();


        if ((length + 2) % 3 != 0) {
            return false;
        }
        int n = (length + 2) / 3;

        for (int i = 0; i < n; i++) {
            int tempI = i + 1;
            if (S[tempI - 1] != S[2 * n - tempI - 1] || S[tempI - 1] != S[2 * n + tempI - 2 - 1] || S[2 * n + tempI - 2 - 1] != S[2 * n - tempI - 1]) {
                return false;
            }
        }
        return true;
    }
}

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {

            int res;

            String _str;
            try {
                _str = in.nextLine();
            } catch (Exception e) {
                _str = null;
            }

            res = new test3_1().solution(_str);
            System.out.println(String.valueOf(res));
        }

    }
}
