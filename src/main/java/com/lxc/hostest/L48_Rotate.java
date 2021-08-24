package com.lxc.hostest;

public class L48_Rotate {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int upper=0;
        int lower=n-1;
        int left=0;
        int right=n-1;
        while (left<right&&lower>upper) {
            for (int i = 0; i < right-left; i++) {

                int temp = matrix[upper+i][right];
                matrix[upper+i][right] = matrix[upper ][left + i];

                int temp2 = matrix[lower][right - i];
                matrix[lower][right-i] = temp;

                temp = matrix[lower - i][left];
                matrix[lower-i][left] = temp2;

                matrix[upper][left + i] = temp;

            }
            right--;
            left++;
            upper++;
            lower--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
