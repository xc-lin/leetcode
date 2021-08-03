package com.lxc.JZOffer;

public class J42_MaxSubArray {
    // 动态规划
    public int maxSubArray(int[] nums) {
        // subproblem: 包含第i个数据的数组加起来最大

        int []opt= new int[nums.length];
        opt[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 判断前面一个加上自己会不会让自己变得更小
            // 如果变得更小那就自己的数字
            // 如果变大就和前面加起来
            opt[i]=Math.max(nums[i],opt[i-1]+nums[i]);
        }
        int result=opt[0];
        for (int i = 1; i < opt.length; i++) {
            if (result<opt[i]){
                result=opt[i];
            }
        }
        return result;
    }

    public int maxSubArrayBest(int[] nums) {
        int result=nums[0];
        int pre=nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre=Math.max(nums[i],pre+nums[i]);
            result=Math.max(pre,result);
        }

        return result;
    }
}
