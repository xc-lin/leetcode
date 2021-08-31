package com.lxc.hostest;

import org.apache.commons.lang.enums.Enum;

public class L240_搜索二维矩阵II {
    // 每次移除一行一列
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            }
            if (value > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}
