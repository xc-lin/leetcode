package com.lxc.hostest;

import java.util.Stack;

public class L42_Trap {
    public int trap(int[] height) {
        // 计算每一个块能接到多少的雨水
        int length=height.length;
        int leftMax[]=new int[length];
        int rightMax[]=new int[length];
        leftMax[0]=height[0];
        rightMax[length-1]=height[length-1];
        // 记录他的左边的最大值
        // 都需要包括自己的高度 因为如果左边的最大值如果小于当前 在后续的计算中会出现负值
        for (int i = 1; i < length; i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        // 记录他的右边的最大值
        for (int i = length-2; i >=0 ; i--) {
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        int result=0;
        for (int i = 1; i < length; i++) {
            // 左边最大值和右边最大值之间最小的那个-当前的高度就是我们能在这个坐标接到的水
            result+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return result;
    }
    public int trap2(int[] height) {
        // 计算每一个块能接到多少的雨水
        int length=height.length;
        int leftMax[]=new int[length];
        int rightMax[]=new int[length];
        leftMax[0]=0;
        rightMax[length-1]=0;
        // 记录他的左边的最大值
        // 不记录自己的位置
        for (int i = 1; i < length; i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        }
        // 记录他的右边的最大值
        // 不记录自己的位置
        for (int i = length-2; i >=0 ; i--) {
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }
        int result=0;
        for (int i = 1; i < length; i++) {
            // 左边最大值和右边最大值之间最小的那个-当前的高度就是我们能在这个坐标接到的水
            result+=Math.max(Math.min(leftMax[i],rightMax[i])-height[i],0);
        }
        return result;
    }

    public int trapStack(int[] height) {
        // 计算每一个块能接到多少的雨水
        int length=height.length;
        int result=0;
        Stack<Integer> stack =new Stack<>();
//        stack.push(-1);

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int index=stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int width=i-left-1;
                int h= Math.min(height[i],height[left])-height[index];
                result+=width*h;
            }
            // 可以保证栈是一个单调递减栈 因此只有在height[i]<height[stack.peek]的时候才会入栈
            stack.push(i);
        }
        return result;
    }

    public static int trapDoublePointer(int[] height) {
        // 计算每一个块能接到多少的雨水
        int length=height.length;
        int result=0;
        int left=0;
        int right=length-1;
        int leftMax=0;
        int rightMax=0;
        while (left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);

            // 保证左指针一定是比右边小
            if (height[left]<height[right]){
                // 同时如果当前指针比leftMax小 那么说明一定可以积水
                if (height[left]<leftMax){
                    // 是一个低洼的地方因为比leftMax小
                    result+=leftMax-height[left];
                }
                left++;
            }else {
                if (height[right]<rightMax){
                    result+=rightMax-height[right];
                }
                right--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trapDoublePointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
