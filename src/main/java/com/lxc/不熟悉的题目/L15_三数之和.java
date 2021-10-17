package com.lxc.不熟悉的题目;

import com.sun.javafx.tools.packager.CreateJarParams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int ll = 0;
        int left;
        int right = length - 1;
        while (ll<length-2&&nums[ll] <= 0) {
            left = ll + 1;
            right=length-1;
            if (ll>0&&nums[ll]==nums[ll-1]){
                ll++;
                continue;
            }
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[ll];
                if (temp < 0) {
                    left++;
                    continue;
                }
                if (temp > 0) {
                    right--;
                    continue;
                }
                if (temp == 0) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[ll]);
                    result.add(list);
                    left++;
                    while (left<=right&&nums[left]==nums[left-1])left++;
                    while (left<=right&&nums[right]==nums[right-1])right--;

                    ;
                }
            }
            ll++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L15_三数之和().threeSum(new int[]{0,0,0,0}));
    }
}
