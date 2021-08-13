package com.lxc.JZOffer2;

public class J17_PrintNumbers {
    public int[] printNumbers(int n) {
        int k = (int) Math.pow(10, n);
        int result[] = new int[k - 1];
        for (int i = 0; i < k; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    StringBuffer result = new StringBuffer();
    int n;
    char num[];
    int zero = 0;

    public String printNumbers2(int n) {
        this.n = n;
        num = new char[n];
        dfs(0);
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public void dfs(int depth) {
        if (depth == n) {
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (num[i] == '0') {
                    start++;
                } else {
                    break;
                }
            }
            int count = n - start;
            if (count != 0) {
                result.append(String.valueOf(num, start, count) + ",");
            }
            return;
        }
        for (int i = 0; i < 10; i++) {

            num[depth] = (char) (i + '0');
            dfs(depth + 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new J17_PrintNumbers().printNumbers2(3));
    }
}