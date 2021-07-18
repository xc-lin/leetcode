package com.lxc.JZOffer;

public class J04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {

            int length2 = matrix[0].length - 1;
            if (length2 == -1) {
                break;
            }
            if (target < matrix[i][0] || target > matrix[i][length2]) {
                continue;
            }
            int low = 0;
            int high = length2;

            while (low <= high) {
                int mid = (high + low) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }
                if (target < matrix[i][mid]) {
                    high = mid - 1;
                }
                if (target > matrix[i][mid]) {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

}
