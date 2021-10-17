package com.lxc.Job.weBank;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        char[] commands = scanner.nextLine().toCharArray();
        int p0 = 0;
        int p1 = 0;
        long result = 0;
        for (int i = 0; i < commands.length; i++) {
            if (i != 0 && commands[i - 1] != commands[i]) {
                result += x;
            }
            if (commands[i] == 'h') {
                if (p1 - 1 < 0 || matrix[p0][p1 - 1] == -1) {
                    result += y;
                } else {
                    result += Math.max(matrix[p0][p1], matrix[p0][--p1]);
                }

            } else if (commands[i] == 'j') {
                if (p0 + 1 >= n || matrix[p0 + 1][p1] == -1) {
                    result += y;
                } else {
                    result += Math.max(matrix[p0][p1], matrix[++p0][p1]);
                }

            } else if (commands[i] == 'k') {
                if (p0 - 1 < 0 || matrix[p0 - 1][p1] == -1) {
                    result += y;
                } else {
                    result += Math.max(matrix[p0][p1], matrix[--p0][p1]);
                }
            } else if (commands[i] == 'l') {
                if (p1 + 1 >= m || matrix[p0][p1 + 1] == -1) {
                    result += y;
                } else {
                    result += Math.max(matrix[p0][p1], matrix[p0][++p1]);
                }
            }

        }
        System.out.println(result);
    }
}
