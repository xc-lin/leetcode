package com.lxc.hostest;

public class L11_MaxArea {
    public int maxArea(int[] height) {
        if (height.length==0){
            return 0;
        }
        int left=0;
        int right=height.length-1;
        int result=0;
        while (left<right){
            if (height[left]<height[right]){
                result= Math.max(height[left]*(right-left),result);
                left++;

            }else {
                result= Math.max(height[right]*(right-left),result);
                right--;
            }

        }
        return result;
    }
}
