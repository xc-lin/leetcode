package com.lxc.JZOffer2;

import java.util.ArrayList;
import java.util.List;

public class J29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int upper = 0, lower = row - 1, left = 0, right = column - 1;
        int result[] = new int[row * column];
        int count = 0;
        while (count < row * column) {
            for (int i = left; i <= right; i++) {
                result[count++] = matrix[upper][i];
            }
            if (++upper>lower){
                break;
            }
            for (int i = upper; i <= lower; i++) {
                result[count++] = matrix[i][right];
            }
            if (--right<left){
                break;
            }
            for (int i = right; i >= left; i--) {
                result[count++] = matrix[lower][i];
            }
            if (--lower<upper){
                break;
            }
            for (int i = lower; i >= upper; i--) {
                result[count++] = matrix[i][left];
            }
            if (left++>right){
                break;
            }
        }
        return result;
    }
}
