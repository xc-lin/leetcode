package com.lxc.hostest;

import java.util.Stack;

public class L85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int width[][] = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        width[i][j] = 1;
                    } else {
                        width[i][j] = width[i][j - 1] + 1;
                    }
                } else {
                    width[i][j] = 0;
                }
                int minWidth = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    minWidth = Math.min(minWidth, width[k][j]);
                    int area = (i - k + 1) * minWidth;
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }


    public int maximalRectangleStack(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int heights[]=new int[n];
        int result=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='1'){
                    heights[j]++;
                }else {
                    heights[j]=0;
                }
            }
            result=Math.max(L84(heights),result);
        }
        return result;
    }

    public int L84(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int result=0;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
            }else if (heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                    int left = stack.pop();
                    int ll=-1;
                    if (!stack.isEmpty()){
                        ll=stack.peek();
                    }
                    int area = (heights[left]*(i-ll-1));
                    result=Math.max(area,result);
                }
                stack.push(i);

            }
        }
        while (!stack.isEmpty()){
            int left = stack.pop();
            int ll=-1;
            if (!stack.isEmpty()){
                ll=stack.peek();
            }
            int area = (heights[left]*(length-ll-1));
            result=Math.max(area,result);
        }
        return result;
    }

    public static void main(String[] args) {
//        new L85_最大矩形().maximalRectangleStack(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        new L85_最大矩形().maximalRectangleStack(new char[][]{{'0', '1'},{'1', '0'}});
    }
}
