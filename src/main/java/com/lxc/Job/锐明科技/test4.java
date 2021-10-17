package com.lxc.Job.锐明科技;

public class test4 {
    public String spiralMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper = 0;
        int lower = m - 1;
        int left = 0;
        int right = n - 1;
        StringBuilder sb = new StringBuilder();
        while (upper < m && lower >= 0 && left < n && right >= 0 && left <= right && lower >= upper) {
            for (int i = left; i <= right; i++) {
                sb.append(matrix[upper][i]);
                sb.append(" ");
            }
            upper++;
            for (int i = upper; i <= lower; i++) {
                sb.append(matrix[i][right]);
                sb.append(" ");
            }
            right--;
            for (int i = right; i >= left; i--) {
                sb.append(matrix[lower][i]);
                sb.append(" ");
            }
            lower--;
            for (int i = lower; i >= upper; i--) {
                sb.append(matrix[i][left]);
                sb.append(" ");
            }
            left++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new test4().spiralMatrix(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
    }
}
