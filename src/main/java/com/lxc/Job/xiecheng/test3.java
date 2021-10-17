package com.lxc.Job.xiecheng;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test3 {
    int result = Integer.MAX_VALUE;
    int nums[];
    int opt[][];
    int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int nums[] = new int[n];
        List<String> lists = new LinkedList<>();

        String line = scanner.nextLine();
        int pre = 0;
        boolean start = true;
        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == '0') {
                lists.add(line.substring(pre, i));
                start = false;
                while (i<line.length()&&line.charAt(i) == '0') {
                    i++;
                }
            }
            if (!start) {
                pre = i;
                start = true;
            }

        }
        if (pre != line.length()) {
            lists.add(line.substring(pre));
        }
        int[][] rules = new int[m][2];
        for (int i = 0; i < m; i++) {
            rules[i][0] = scanner.nextInt();
            rules[i][1] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println(lists.toString());
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(rules[i]));
        }
        int result = 0;
        for (int i = 0; i < lists.size(); i++) {
            char[] chars = lists.get(i).toCharArray();
            int length = chars.length;
            int opt[] = new int[length];
            int tempMax = 0;
            for (int j = 0; j < length; j++) {
                int max = 0;
                for (int k = 0; k < m; k++) {
                    int preIndex = j - rules[k][0] + 1;
                    if (preIndex >= 0) {
                        int pre11 = (preIndex - 1) < 0 ? 0 : opt[preIndex - 1];
                        max = Math.max(max, pre11 + rules[k][1]);
                    }
                }
                opt[j] = max;
                tempMax = Math.max(max, tempMax);
            }
            result += tempMax;
        }
        System.out.println(result);

    }

    //7 2
//1111111
//3 10
//4 15
    public void dfs(int temp, int depth, int k, int i) {
        if (depth == k) {
            temp = Math.max(temp, opt[i][n - 1]);
            result = Math.min(temp, result);
            return;
        }
        for (int j = i; j <= n - k + depth - 1; j++) {
            dfs(Math.max(temp, opt[i][j]), depth + 1, k, j + 1);
        }

    }

}
