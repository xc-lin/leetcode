package com.lxc.JZOffer2;

import java.util.HashMap;

public class J39_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                int temp = map.get(nums[i]);
                if ((++temp)  >= Math.ceil(length / 2.0)) {
                    return nums[i];
                }
                map.put(nums[i], temp);

            }else {
                map.put(nums[i], 1);
            }

        }
        return 0;
    }

    public int majorityElementBest(int[] nums) {
        // 将vote首先置为1
        int vote=1;
        // result 为第一个数
        int result=nums[0];
        // 遍历nums
        for (int i = 1; i < nums.length; i++) {
            // 当votes 不为1 说明此时众数 还没有和其他的抵消
            if (vote!=0){
                // 如果此时这个值和众数相同时 vote继续增加
                if (nums[i]==result){
                    vote++;
                }else {
                    // 反之则减少 如果此时减少到vote=0 下一次进入遍历时 下一个数 就是众数
                    vote--;
                }
            }else {
                // vote==0 那么直接让这个数为众数并让vote++
                result=nums[i];
                vote++;
            }
        }
        if (vote>0){
            // 如果存在一个数大于他的一半那么一定有一个数的vote大于0
            return  result;
        }
        return 0;
    }

    public static void main(String[] args) {
        new J39_MajorityElement().majorityElement(new int[]{1});
    }
}
