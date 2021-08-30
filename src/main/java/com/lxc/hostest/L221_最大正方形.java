package com.lxc.hostest;

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class L221_最大正方形 {


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int width[][] = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j] - '0';
                if (j == 0) {
                    width[i][j] = value;
                } else if (value == 0) {
                    width[i][j] = 0;
                } else {
                    width[i][j] = width[i][j - 1] + value;
                }
                int minWidth = width[i][j];
                int height = 1;
                for (int k = i; k >= 0; k--) {
                    height = i - k + 1;
                    if (matrix[k][j] == 0 || height > width[k][j]) {
                        break;
                    }
                    minWidth = Math.min(minWidth, width[k][j]);
                    height = Math.min(minWidth, height);
                    result = Math.max(height * height, result);
                }

            }

        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(width[i]));
        }
        return result;
    }

    public int maximalSquareBest(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int area[][] = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            area[i][0] = matrix[i][0] - '0';
            result = Math.max(area[i][0], result);
        }

        for (int i = 0; i < n; i++) {
            area[0][i] = matrix[0][i] - '0';
            result = Math.max(area[0][i], result);

        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] =='0'){
                    area[i][j]=0;
                }else {
                    area[i][j] = Math.min(area[i - 1][j - 1], Math.min(area[i][j - 1], area[i - 1][j])) + 1;
                    result = Math.max(area[i][j], result);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        System.out.println(new L221_最大正方形().maximalSquareBest(new char[][]{{'1', '0', '1', '1', '0', '1'}, {'1', '1', '1', '1', '1', '1'}, {'0', '1', '1', '0', '1', '1'}, {'1', '1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '1', '1'}, {'1', '1', '0', '1', '1', '1'}}));
    }
}

