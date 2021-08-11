package com.lxc.JZOffer2;

public class J04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0, j = column - 1;
        while (i >= 0 && i < row && j >= 0 && j < column) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            }
            if (value > target) {
                j--;
            }
            if (value < target) {
                i++;
            }
        }
        return false;

    }
}
