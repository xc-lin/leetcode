package com.lxc.hostest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class L84_柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len==0){
            return 0;
        }
        if (len==1){
            return heights[0];
        }
        int result=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()){
                if (heights[i]>=heights[stack.peek()]){
                    stack.push(i);
                    break;
                }else {
                    if (stack.size()==1){
                        int index = stack.pop();
                        int area = heights[index] * (i);
                        result = Math.max(result, area);
                    }else {
                        int index = stack.pop();
                        int area = heights[index] * (i - stack.peek()-1);
                        result = Math.max(result, area);
                    }
                }
            }
            if (stack.isEmpty()){
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            if (stack.size()==1){
                int index = stack.pop();
                int area = heights[index] * (len);
                result = Math.max(result, area);
            }else {
                int i = len ;
                int index = stack.pop();
                int area = heights[index] * (i - stack.peek()-1);
                result = Math.max(result, area);
            }
        }
        return result;
    }

    public int largestRectangleAreaBruceForce(int[] heights) {
        int len = heights.length;
        if (len==0){
            return 0;
        }
        if (len==1){
            return heights[0];
        }
        int result=0;
        for (int i = 0; i < len; i++) {
            int left=i;
            int right=i;
            while (left>=0&&heights[left]>=heights[i]){
                left--;
            }
            while (right<len&&heights[right]>=heights[i]){
                right++;
            }
            result=Math.max(result,heights[i]*(right-left-1));
        }
        return result;
    }

    public static void main(String[] args) {
        new L84_柱状图中最大的矩形().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}