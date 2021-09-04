package com.lxc.hostest;

import java.util.ArrayList;
import java.util.List;

public class L448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]-1!=i&&nums[i]!=-1){
                if (nums[nums[i]-1]==nums[i]){
                    nums[i]=-1;
                    break;
                }
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==-1){
                result.add(i+1);
            }
        }
        return result;
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int length=nums.length;
        for (int i = 0; i < nums.length; i++) {
            int temp=(nums[i]-1)%length;
            nums[temp]=nums[temp]+length;
        }
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=length){
                result.add(i+1);
            }
        }
        return result;
    }
}
